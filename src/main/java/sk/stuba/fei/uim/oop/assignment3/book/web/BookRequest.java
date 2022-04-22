package sk.stuba.fei.uim.oop.assignment3.book.web;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;

@Data
public class BookRequest {

    private String name;
    private String description;
    private int authorId;
    private int pages;
    private int amount;
    private int lendCount;

}
