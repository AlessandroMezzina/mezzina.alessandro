package com.bookstore.App;
import com.bookstore.model.*;
import java.math.*;

public class BookStore {
    public static void main(String[] args) {
        Book b=new Book(0L, "Guida galattica per autostoppisti", "Douglas Adams");

        BigDecimal bd=new BigDecimal("9.99");
        Book b2=new Book(1L, "Guida galattica per autostoppisti", "Douglas Adams", bd);

        System.out.println(b);
        System.out.println(b2);

    }
}
