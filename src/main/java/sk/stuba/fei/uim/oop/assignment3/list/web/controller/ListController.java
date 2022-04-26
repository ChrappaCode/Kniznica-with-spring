package sk.stuba.fei.uim.oop.assignment3.list.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.web.AmountResponseRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.BadRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;
import sk.stuba.fei.uim.oop.assignment3.list.service.IListService;
import sk.stuba.fei.uim.oop.assignment3.list.web.ListRequest;
import sk.stuba.fei.uim.oop.assignment3.list.web.ListResponse;

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

    @PostMapping(value = "/{id}/add" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListResponse addBookToList(@PathVariable("id") Long id, @RequestBody ListRequest request) throws NotFound, BadRequest {
        return new ListResponse(this.service.addBookToList(id, request));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteList(@PathVariable("id") Long id) throws NotFound {
        this.service.delete(id);
    }

}
