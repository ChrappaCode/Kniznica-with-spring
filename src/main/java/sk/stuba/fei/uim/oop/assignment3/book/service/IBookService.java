package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.AmountResponseRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();
    Book create(BookRequest request) throws NotFound;

    Book getBookById(Long id) throws NotFound;
    long getBookAmount(Long id) throws NotFound;
    long getBookLendCount(Long id) throws NotFound;
    long increaseAmount(Long id , AmountResponseRequest request) throws NotFound;
    Book update(Long id, BookRequestEdit request) throws NotFound;
    void delete(long id) throws NotFound;

}
