package sk.stuba.fei.uim.oop.assignment3.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.author.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.web.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;


import java.util.List;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author newAuthor = new Author();
        newAuthor.setName(request.getName());
        newAuthor.setSurname(request.getSurname());
        return this.repository.save(newAuthor);
    }

    @Override
    public Author getAuthorById(Long id) throws NotFound{

        if (this.repository.findAuthorById(id) == null) {
            throw new NotFound();
            }
        return this.repository.findAuthorById(id);
    }

    @Override
    public Author update(Long id, AuthorRequest request) throws NotFound {
        Author updatedAuthor = this.getAuthorById(id);
        if (request.getName() != null) {
            updatedAuthor.setName(request.getName());
        }
        if (request.getSurname() != null) {
            updatedAuthor.setSurname(request.getSurname());
        }
        return this.repository.save(updatedAuthor);
    }

    @Override
    public void delete(long id) throws NotFound {
        this.repository.delete(this.getAuthorById(id));
    }



}


