package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookReqeust;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();

    Book create(BookReqeust request) throws NotFound;
    Book getBookById(Long id) throws NotFound;
    Book update(Long id, BookReqeust request) throws NotFound;
    void delete(long id) throws NotFound;

}
