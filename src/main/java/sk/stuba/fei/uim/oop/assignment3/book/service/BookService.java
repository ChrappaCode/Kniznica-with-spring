package sk.stuba.fei.uim.oop.assignment3.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.author.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.book.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository repository1;

    @Override
    public List<Book> getAllBooks() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) throws NotFound {

        if (this.repository1.findAuthorById(request.getAuthorId()) == null) {
            throw new NotFound();
        }
        Author a = this.repository1.findAuthorById(request.getAuthorId());

        Book newBook = new Book();

        newBook.setName(request.getName());
        newBook.setDescription(request.getDescription());
        newBook.setAuthor(request.getAuthorId());
        newBook.setPages(request.getPages());
        newBook.setAmount(request.getAmount());
        newBook.setLendCount(request.getLendCount());
        return this.repository.save(newBook);
    }

    @Override
    public Book getBookById(Long id) throws NotFound {
        return null;
    }

    @Override
    public Book update(Long id, BookRequest request) throws NotFound {
        return null;
    }

    @Override
    public void delete(long id) throws NotFound {

    }
}
