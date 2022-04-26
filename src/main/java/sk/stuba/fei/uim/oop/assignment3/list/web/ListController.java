package sk.stuba.fei.uim.oop.assignment3.list.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.web.AuthorResponse;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;
import sk.stuba.fei.uim.oop.assignment3.list.service.IListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private IListService service;

    @GetMapping()
    public List<ListResponse> getAllLists(){
        return this.service.getAllLists().stream().map(ListResponse::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ListResponse getAllLists(@PathVariable("id") Long id) throws NotFound {
        return new ListResponse(this.service.getListById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListResponse> createList() {
        return new ResponseEntity<>(new ListResponse(this.service.createList()) , HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteList(@PathVariable("id") Long id) throws NotFound {
        this.service.delete(id);
    }

}
