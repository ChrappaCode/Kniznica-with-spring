package sk.stuba.fei.uim.oop.assignment3.author.author;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(orphanRemoval = true)
    private List<Book> books;

    public Author() {
        this.books = new ArrayList<>();
    }

}
