package sk.stuba.fei.uim.oop.assignment3.book.web;

import lombok.Data;

@Data
public class BookRequestEdit {

    private String name;
    private String description;
    private long author;
    private int pages;

}
