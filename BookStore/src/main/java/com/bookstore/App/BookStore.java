package com.bookstore.App;
import com.bookstore.model.*;
import java.math.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) {
        Book b=new Book(0L, "Guida galattica per autostoppisti", "Douglas Adams");
        BigDecimal bd=new BigDecimal("9.99");
        Book b2=new Book(1L, "Guida galattica per autostoppisti", "Douglas Adams", bd);
        System.out.println("\t***Stampa statica***\t");
        System.out.println(b);
        System.out.println(b2);
        System.out.println("\t***Stampa dinamica***\t");

        ArrayList<Book> books=loadBook();
        for(int i=0;i<books.size();i++) System.out.println(books.get(i));
    }

    private static ArrayList<Book> loadBook(){
        Scanner scanner=new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>();

        Boolean bool=true;
        while(bool) {

            System.out.print("Inserire ID del libro: ");
            //long id=scanner.nextLong();
            long id=Long.parseLong(scanner.nextLine());
            System.out.print("\nInserire titolo del libro: ");
            String title=scanner.nextLine();
            System.out.print("\nInserire autore del libro: ");
            String author=scanner.nextLine();
            System.out.print("\nInserire prezzo del libro (lasciare vuoto se gratis): ");
            String price=scanner.nextLine();
            BigDecimal bd;
            Book b;
            if(price.isEmpty()) {
                bd=null;
                b=new Book(id, title, author);
            }
            else {
                bd=new BigDecimal(price);
                b=new Book(id, title, author, bd);
            }
            
            //System.out.println(b);
            books.add(b);

            System.out.print("Vuoi caricare un altro libro? (s)(n): ");
            String c=scanner.nextLine();
            if(c.equals("n")||(c.equals("N"))) bool=false;
        }

        scanner.close();
        return books;
    }
}
