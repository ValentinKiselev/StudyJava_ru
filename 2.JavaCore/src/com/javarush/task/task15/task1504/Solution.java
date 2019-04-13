package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            if(this instanceof MarkTwainBook) output = markTwainOutput;
            else if(this instanceof AgathaChristieBook) output = agathaChristieOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book{
        String title = "Mark Twain";
    public MarkTwainBook(String author){
        super("Mark Twain");
        title = author;
    }
        public MarkTwainBook getBook(){
        return this;
        }
        public String getTitle(){
        return this.title;
        }
    }

    public static class AgathaChristieBook extends Book{
        String title = "Agatha Christie";
        public AgathaChristieBook(String author){
            super("Agatha Christie");
            title = author;
        }
        public AgathaChristieBook getBook(){
            return this;
        }
        public String getTitle(){
            return this.title;
        }
    }
}
