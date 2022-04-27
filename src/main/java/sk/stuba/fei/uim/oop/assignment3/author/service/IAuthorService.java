package sk.stuba.fei.uim.oop.assignment3.author.service;

import sk.stuba.fei.uim.oop.assignment3.author.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;

public interface IAuthorService {

    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getAuthorById(Long id) throws NotFound;
    Author update(Long id, AuthorRequest request) throws NotFound;
    void delete(long id) throws NotFound;
}
