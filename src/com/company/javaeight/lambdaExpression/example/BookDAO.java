package com.company.javaeight.lambdaExpression.example;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "CoreJava", 1400));
        books.add(new Book(102, "HTML", 140));
        books.add(new Book(103, "C++", 1200));
        books.add(new Book(104, "Python", 1100));
        books.add(new Book(105, "JavaScript", 1000));
        return books;
    }
}
