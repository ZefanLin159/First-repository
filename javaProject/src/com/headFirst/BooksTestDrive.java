package com.headFirst;

public class BooksTestDrive {
    public static void main(String[] args) {
        Books[] myBooks = new Books[3];
        myBooks[0] = new Books();
        myBooks[0].title = "Java";
        myBooks[0].author = "zf";

        System.out.print(myBooks[0].title + myBooks[0].author);
    }
}
