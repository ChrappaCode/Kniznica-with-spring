package sk.stuba.fei.uim.oop.assignment3.author.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.service.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorResponse;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private IAuthorService service;

    @GetMapping()
    public List<AuthorResponse> getAllAuthors(){
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public AuthorResponse getAllAuthors(@PathVariable("id") Long id) throws NotFound {
        return new AuthorResponse(this.service.getAuthorById(id));
    }

    @PutMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorResponse updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorRequest body) throws NotFound {
        return new AuthorResponse(this.service.update(id, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) throws NotFound {
        this.service.delete(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request){
        return new ResponseEntity<>(new AuthorResponse(this.service.create(request)) , HttpStatus.CREATED);
    }

}
