package sk.stuba.fei.uim.oop.assignment3.list.service;

import sk.stuba.fei.uim.oop.assignment3.exeption.BadRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListEnt;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.ListRequest;

import java.util.List;

public interface IListService {

    List<ListEnt> getAllLists();
    ListEnt getListById(Long id) throws NotFound;
    ListEnt createList();
    ListEnt addBookToList(Long id , ListRequest request) throws NotFound, BadRequest;
    void lendList(long id) throws NotFound,BadRequest;
    void delete(long id) throws NotFound;
    void delete(long id , ListRequest request) throws NotFound;

}
