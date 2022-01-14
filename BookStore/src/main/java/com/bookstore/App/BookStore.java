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
        Book eliminaBook=null;
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
            eliminaBook=singleBook;
            singleBook.addAuthor(autori[j]);
            bs.addBook(singleBook);

            System.out.print("Inserire un nuovo libro? s/n: ");
            scelta=scanner.nextLine();
            i++;
            j++;
        } while(scelta.toLowerCase().equals("s"));

        bs.removeBook(eliminaBook);
        bs.printBook();

        Book[] search=bs.searchBookByTitle("prova");
        for(int k=0;k<search.length;k++) System.out.println(search[k]);
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

    private void removeBook(Book book) {
        int count=0;

        BookStore bs=new BookStore();
        for(int i=0;i<books.length;i++) {
            if(books[i].equals(book)) {
                books[i]=null;
                count++;
            }
        }
        bs.shiftBooks();

        books=Arrays.copyOf(books, books.length-count);  
    }

    private void shiftBooks() {
        for(int i=0;i<books.length; i++) {
            if(books[i].equals(null)) {
                for(int j=i;j<books.length-1; j++) {
                    books[j]=books[j+1];
                }
            }
        }
    }

    private Book[] searchBookByTitle(String title) {
        Book[] search={};
        int j=0;
        for(int i=0;i<books.length;i++) {
            if(books[i].getTitle().equals(title)) {
                search=Arrays.copyOf(search, search.length+1);
                search[j]=books[i];
                j++;
            }
        }
        return search;
    }
}
