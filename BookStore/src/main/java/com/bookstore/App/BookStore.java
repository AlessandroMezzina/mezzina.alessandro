package com.bookstore.App;
import com.bookstore.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class BookStore {
    public Book[] books={};

    public static void main(String[] args) {
        Author[] autori=new Author[0];
        String scelta="";
        Scanner scanner=new Scanner(System.in);
        BookStore bs=new BookStore();
        long i=0L;
        int j=0;
        do {
            System.out.print("Inserire titolo del libro: ");
            String title=scanner.nextLine();

            /*Retrieve author information*/
            System.out.print("Inserire nome autore: ");
            String firstName=scanner.nextLine();
            System.out.print("Inserire cognome autore: ");
            String lastName=scanner.nextLine();
            autori=Arrays.copyOf(autori, autori.length+1);
            autori[j]=new Author(i, firstName, lastName);

            /*Retrieve price information*/
            System.out.print("Inserire prezzo (lasciare vuoto se gratis): ");
            String price=scanner.nextLine();
            BigDecimal bd=null;
            if(!price.isEmpty()) bd=new BigDecimal(price);

            System.out.print("Inserire editore: ");
            String publisher=scanner.nextLine();
            Publisher pub=new Publisher(i, publisher);

            Book singleBook=new Book(i, title, autori, pub, bd);
            bs.addBook(singleBook);

            System.out.print("Inserire un nuovo libro? s/n: ");
            scelta=scanner.nextLine();
            i++;
            j++;
        } while(scelta.toLowerCase().equals("s"));

        bs.printBook();

        scanner.close();
    }

    private void addBook(Book book) {
        books=Arrays.copyOf(books, books.length+1);
        books[books.length-1]=book;
    }

    private void printBook() {
        for(int i=0;i<books.length;i++)
            System.out.println(books[i]);
    }

    /*private static ArrayList<Book> loadBook(){
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
            if (!price.isEmpty()) bd=new BigDecimal(price);
            Book b;
            Publisher publisher=null;

            if(scelta.equals("s") || scelta.equals("S")) {
                System.out.print("\nInserire editore: ");
                String publisherName=scanner.nextLine();
                publisher=new Publisher(i, publisherName);
            }

            b=new Book(i, title, author, publisher, bd);
            
            books.add(b);

            System.out.print("Vuoi caricare un altro libro? (s)(n): ");
            String c=scanner.nextLine();
            if(c.equals("n")||(c.equals("N"))) bool=false;
        }

        scanner.close();
        return books;
    }*/
}
