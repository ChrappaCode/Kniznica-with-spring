package sk.stuba.fei.uim.oop.assignment3.list.service;

import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListEnt;

import java.util.List;

public interface IListService {

    List<ListEnt> getAllLists();
    ListEnt createList();

}
