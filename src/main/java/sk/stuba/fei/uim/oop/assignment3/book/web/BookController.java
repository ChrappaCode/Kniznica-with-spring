package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;

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

}
