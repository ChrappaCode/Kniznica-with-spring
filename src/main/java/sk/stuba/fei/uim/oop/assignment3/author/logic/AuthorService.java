package sk.stuba.fei.uim.oop.assignment3.author.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.web.AuthorRequest;


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

}
