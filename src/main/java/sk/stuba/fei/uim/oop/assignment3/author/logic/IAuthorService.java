package sk.stuba.fei.uim.oop.assignment3.author.logic;

import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.web.AuthorRequest;

import java.util.List;

public interface IAuthorService {

    List<Author> getAll();
    Author create(AuthorRequest request);

}
