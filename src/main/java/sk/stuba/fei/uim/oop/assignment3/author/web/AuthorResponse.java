package sk.stuba.fei.uim.oop.assignment3.author.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;

import java.util.List;

@Getter
public class AuthorResponse {

    private final Long id;

    private final String name;
    private final String surname;

    private final List<Book> books;

    public AuthorResponse(Author author){

        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.books = author.getBooks();

    }

}
