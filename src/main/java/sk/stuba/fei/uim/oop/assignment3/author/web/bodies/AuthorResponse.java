package sk.stuba.fei.uim.oop.assignment3.author.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;

import java.util.ArrayList;
import java.util.List;


@Getter
public class AuthorResponse {

    private final Long id;

    private final String name;
    private final String surname;

    private final List<Long> books = new ArrayList<>();

    public AuthorResponse(Author author){

        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        for(int i=0;i<author.getBooks().size();i++){
            this.books.add(author.getBooks().get(i).getId());
        }


    }

}
