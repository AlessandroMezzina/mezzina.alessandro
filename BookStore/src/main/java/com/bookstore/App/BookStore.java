package com.bookstore.App;
import com.bookstore.model.*;
import java.math.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) {
        System.out.println("\t***Stampa dinamica***\t");

        ArrayList<Book> books=loadBook();
        for(int i=0;i<books.size();i++) System.out.println(books.get(i));
    }

    private static ArrayList<Book> loadBook(){
        Scanner scanner=new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>();

        Boolean bool=true;
        long i=0L;
        while(bool) {
            System.out.print("\nInserire titolo del libro: ");
            String title=scanner.nextLine();
            System.out.print("\nInserire nome autore del libro: ");
            String authorName=scanner.nextLine();
            System.out.print("\nInserire cognome autore del libro: ");
            String authorSurname=scanner.nextLine();
            Author author=new Author(i, authorName, authorSurname);
            System.out.print("\nInserire prezzo del libro (lasciare vuoto se gratis): ");
            String price=scanner.nextLine();

            System.out.print("\nVuoi inserire l'editore? (s/n): ");
            String scelta=scanner.nextLine();

            BigDecimal bd=null;
            Book b;
            Publisher publisher=null;

            if(scelta.equals("s") || scelta.equals("S")) {
                System.out.print("\nInserire editore: ");
                String publisherName=scanner.nextLine();
                publisher=new Publisher(i, publisherName);
            }

            if(publisher==null) {
                if(price.isEmpty()) {
                    bd=null;
                    b=new Book(i, title, author);
                }
                else {
                    bd=new BigDecimal(price);
                    b=new Book(i, title, author, publisher, bd);
                }
            }
            else b=new Book(i, title, author, publisher, bd);
            
            books.add(b);

            System.out.print("Vuoi caricare un altro libro? (s)(n): ");
            String c=scanner.nextLine();
            if(c.equals("n")||(c.equals("N"))) bool=false;
        }

        scanner.close();
        return books;
    }
}
