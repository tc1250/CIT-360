/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcchr
 */
public class Book {

    private String title;
    private String author;
    private String description;
    private String isbn;

    public Book() {
        //can ititialize a book as empty
    }

    public Book(String title, String author, String des, String isbn) {
        this.title = title;
        this.author = author;
        this.description = des;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        int maxLength;
        if (description.length() >= 100) {
            maxLength = 100;
        } else {
            maxLength = description.length();
        }

        return "Book{" + "title=" + title + ", author=" + author + ", description=" + description.substring(0, maxLength)+ ", isbn=" + isbn + '}';
    }

}
