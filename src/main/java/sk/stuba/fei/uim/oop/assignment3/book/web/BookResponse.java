package sk.stuba.fei.uim.oop.assignment3.book.web;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;


@Data
public class BookResponse {

    private final Long id;

    private final String name;
    private final String description;

    private final Long author;

    private final int pages;
    private final int amount;
    private final int lendCount;

    public BookResponse(Book book){

        this.id = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.author = book.getAuthor().getId();
        this.pages = book.getPages();
        this.amount = book.getAmount();
        this.lendCount = book.getLendCount();

    }

}
