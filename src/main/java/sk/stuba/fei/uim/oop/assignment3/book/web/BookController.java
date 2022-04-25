package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService service;

    @GetMapping()
    public List<BookResponse> getAllBooks(){
        return this.service.getAllBooks().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id) throws NotFound {
        return new BookResponse(this.service.getBookById(id));
    }

    @GetMapping(value = "/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public AmountResponse getAmount(@PathVariable("id") Long id) throws NotFound {
        return new AmountResponse(this.service.getBookAmount(id));
    }

    @PutMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public BookResponse updateAuthor(@PathVariable("id") Long id, @RequestBody BookRequestEdit body) throws NotFound {
        return new BookResponse(this.service.update(id, body));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long id) throws NotFound {
        this.service.delete(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request) throws NotFound {
        return new ResponseEntity<>(new BookResponse(this.service.create(request)) , HttpStatus.CREATED);
    }

}
