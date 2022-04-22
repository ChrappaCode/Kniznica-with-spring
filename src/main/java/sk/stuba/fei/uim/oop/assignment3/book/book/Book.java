package sk.stuba.fei.uim.oop.assignment3.book.book;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.author.Author;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    //@ManyToOne

    private int author;
    private int pages;
    private int amount;
    private int lendCount;

}
