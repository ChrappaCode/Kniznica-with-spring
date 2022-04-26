package sk.stuba.fei.uim.oop.assignment3.list.list;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ListEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(orphanRemoval = true)
    private List<Book> lendingList;

    private boolean lended;

    public ListEnt() {
        this.lendingList = new ArrayList<>();
    }

}
