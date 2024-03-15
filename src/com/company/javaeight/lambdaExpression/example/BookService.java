package com.company.javaeight.lambdaExpression.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {
    public List<Book> getSortedBook(){
        List<Book> books = new BookDAO().getBooks();
        // older method
        Collections.sort(books, ( o1,  o2) ->
             o1.getPages() - o2.getPages()
        );
//        books.sort(new MyComparator());
        return books;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getSortedBook());
    }
}
//older methods
class MyComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPages() - o2.getPages();
    }
}
