package sk.stuba.fei.uim.oop.assignment3.author.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.author.logic.IAuthorService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private IAuthorService service;

    @GetMapping()
    public List<AuthorResponse> getVsetkyZvierata(){
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }
}
