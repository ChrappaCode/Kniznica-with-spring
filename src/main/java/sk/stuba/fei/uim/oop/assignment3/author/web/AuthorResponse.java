package sk.stuba.fei.uim.oop.assignment3.author.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.Book;

import java.util.List;

@Getter
public class AuthorResponse {

    private Long id;

    private String name;
    private String surname;

    private List<Book> books;

    public AuthorResponse(Author author){

        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.books = author.getBooks();

    }

}
