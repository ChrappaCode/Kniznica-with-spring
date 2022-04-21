package sk.stuba.fei.uim.oop.assignment3.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.book.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookReqeust;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAllBooks() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookReqeust request) throws NotFound {
        return null;
    }

    @Override
    public Book getBookById(Long id) throws NotFound {
        return null;
    }

    @Override
    public Book update(Long id, BookReqeust request) throws NotFound {
        return null;
    }

    @Override
    public void delete(long id) throws NotFound {

    }
}
