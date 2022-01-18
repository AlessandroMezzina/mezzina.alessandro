package com.bookstore.App;
import com.bookstore.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookStore {
    private static final Logger log=LoggerFactory.getLogger(BookStore.class);
    public Book[] books={};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BookStore bs=new BookStore();
        int scelta=-1;
        String menu="\t**********MENU**********"+
                    "\n1) Aggiungi un libro"+
                    "\n2) Rimuovi un libro"+
                    "\n3) Stampa libri"+
                    "\n4) Cerca un libro dal titolo"+
                    "\n5) Cerca un libro dall'autore"+
                    "\n6) Esci"+
                    "\n\n Effettua una scelta: ";
        do {
            System.out.print(menu);
            scelta=Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    log.info("Aggiunta del libro...");
                    bs.addBook(generaLibro(scanner));
                    break;
                case 2:
                    Book b=generaLibro(scanner);
                    bs.removeBook(b);
                    break;
                case 3:
                    bs.printBook();
                    break;
                case 4:
                    System.out.print("Inserire titolo del libro: ");
                    String title=scanner.nextLine();
                    printBook(bs.searchBookByTitle(title));
                    break;
                case 5:
                    Author author=generaAutore(scanner);
                    printBook(bs.searchBookByAuthor(author));
                    break;
                case 6:
                    String str="Sicuro di voler chiudere?"+
                                "\n\t- Premere s o S per confermare"+
                                "\n\t- Premere qualsiasi altro tasto per ignorare"+
                                "\n Digita la tua risposta: ";
                    System.out.print(str);
                    if(scanner.nextLine().toLowerCase().equals("s")) break;
                    else {scelta=1; continue;}
                default:
                    System.out.println("La scelta inserita non e' valida");
            }
        } while(scelta>0 && scelta<6);
        scanner.close();
    }

    private static Book generaLibro(Scanner scanner) {
        System.out.print("Inserire id del libro: ");
        Long id=Long.parseLong(scanner.nextLine());
        System.out.print("Inserire titolo del libro: ");
        String title=scanner.nextLine();
        System.out.print("Inserire numero di autori: ");
        int numAutori=Integer.parseInt(scanner.nextLine());
        Author[] autori=new Author[numAutori];
        for(int i=0;i<numAutori;i++) autori[i]=generaAutore(scanner);
        System.out.print("Inserire ID editore: ");
        Long idP=Long.parseLong(scanner.nextLine());
        System.out.print("Inserire editore: ");
        String editore=scanner.nextLine();
        Publisher publisher=new Publisher(idP, editore);
        System.out.print("Inserire prezzo del libro: ");
        String price=scanner.nextLine();
        BigDecimal bd=new BigDecimal(price);

        Book b=new Book(id, title, autori, publisher, bd);
        catMenu(scanner, b);
        return b;
    }

    private static void catMenu(Scanner scanner, Book b) {
        BookCategory[] values=BookCategory.values();
        String menu="\n\tDi quale categoria fa parte il libro?";
        int i=0;
        for(i=0;i<values.length;i++) {
            menu+="\n\t\t"+(i+1)+") "+values[i];
        }
        menu+="\n\t\tx) ESCI";
        int scelta=-1;
        System.out.print("Inserire numero di categorie: ");
        int nCat=Integer.parseInt(scanner.nextLine());
        String choice="";
        for(i=0;i<nCat;i++) {
            while(scelta<1 || scelta>5) {
                System.out.print(menu);
                System.out.print("\n\tEffettuare una scelta: ");
                choice=scanner.nextLine();
                if(choice.toLowerCase().equals("x")) break;
                scelta=Integer.parseInt(choice);
                b.addCategory(values[scelta-1]);
                log.info("Adding category {}", values[scelta-1]);
            }
        }
    }

    private static Author generaAutore(Scanner scanner) {
        System.out.print("Inserire id autore: ");
        Long id=Long.parseLong(scanner.nextLine());
        System.out.print("Inserire nome autore: ");
        String firstName=scanner.nextLine();
        System.out.print("Inserire cognome autore: ");
        String lastName=scanner.nextLine();

        return new Author(id, firstName, lastName);
    }

    private void addBook(Book book) {
        log.info("Adding book with id {}", book.getId());
        books=Arrays.copyOf(books, books.length+1);
        books[books.length-1]=book;
    }

    private void printBook() {
        for(int i=0;i<books.length;i++)
            System.out.println(books[i]);
    }

    private static void printBook(Book[] search) {
        if(search.length==0) System.out.println("Non e' stato trovato nessun libro");
        else 
            for(int i=0;i<search.length;i++)
                System.out.println(search[i]);
    }

    private void removeBook(Book book) {
        Book[] remove={};
        for(int i=0;i<books.length;i++) {
            if(books[i].getId()!=book.getId()) {
                remove=Arrays.copyOf(remove, remove.length+1);
                remove[remove.length-1]=books[i];
            }
        }

        books=Arrays.copyOf(remove, remove.length);
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

    private Book[] searchBookByAuthor(Author author) {
        Book[] search={};
        int j=0;
        for(int i=0;i<books.length;i++) {
            if(hasAuthor(author, books[i].getAuthors())) {
                search=Arrays.copyOf(search, search.length+1);
                search[j]=books[i];
                j++;
            }
        }
        return search;
    }

    private Boolean hasAuthor(Author author, Author[] list) {
        boolean b=false;
        
        for(int i=0;i<list.length;i++) {
            if(list[i].equals(author)) b=true;
        }

        return b;
    }
}
