package sk.stuba.fei.uim.oop.assignment3.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.service.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.book.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.AmountResponseRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository repository;

    @Autowired
    private IAuthorService authorService;

    @Override
    public List<Book> getAllBooks() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) throws NotFound {

        Author a = authorService.getAuthorById(request.getAuthor());

        Book newBook = new Book();

        newBook.setName(request.getName());
        newBook.setDescription(request.getDescription());
        newBook.setAuthor(a);
        newBook.setPages(request.getPages());
        newBook.setAmount(request.getAmount());
        newBook.setLendCount(request.getLendCount());

        a.getBooks().add(newBook);
        return this.repository.save(newBook);
    }

    @Override
    public Book getBookById(Long id) throws NotFound {

        if (this.repository.findBookById(id) == null) {
            throw new NotFound();
            }
        return this.repository.findBookById(id);

    }

    @Override
    public long getBookAmount(Long id) throws NotFound {

        if (this.repository.findBookById(id) == null) {
            throw new NotFound();
        }
        return this.repository.findBookById(id).getAmount();

    }

    @Override
    public long getBookLendCount(Long id) throws NotFound {

        if (this.repository.findBookById(id) == null) {
            throw new NotFound();
        }
        return this.repository.findBookById(id).getLendCount();

    }

    @Override
    public long increaseAmount(Long id , AmountResponseRequest request) throws NotFound{

        Book book = this.getBookById(id);
        book.setAmount((int) (book.getAmount() + request.getAmount()));
        this.repository.save(book);
        return this.repository.findBookById(id).getAmount();

    }

    @Override
    public Book update(Long id, BookRequestEdit request) throws NotFound {

        Book updatedBook = this.getBookById(id);

        if(request.getAuthor() != 0){
            Author a = authorService.getAuthorById(request.getAuthor());
            updatedBook.getAuthor().getBooks().remove(updatedBook);
            updatedBook.setAuthor(a);
            a.getBooks().add(updatedBook);

        }

        if (request.getName() != null) {
            updatedBook.setName(request.getName());
        }
        if (request.getDescription() != null) {
            updatedBook.setDescription(request.getDescription());
        }


        if (request.getPages() != 0){
            updatedBook.setPages(request.getPages());
        }

        return this.repository.save(updatedBook);
    }

    @Override
    public void delete(long id) throws NotFound {
        Book deleteBook = this.getBookById(id);
        deleteBook.getAuthor().getBooks().remove(deleteBook);
        this.repository.delete(deleteBook);
    }
}
