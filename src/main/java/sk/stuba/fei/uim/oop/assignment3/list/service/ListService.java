package sk.stuba.fei.uim.oop.assignment3.list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.service.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.book.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListEnt;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListRepository;

import java.util.List;

@Service
public class ListService implements IListService{

    @Autowired
    private ListRepository repository;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private IBookService bookService;

    @Override
    public List<ListEnt> getAllLists() {
        return this.repository.findAll();
    }

}
