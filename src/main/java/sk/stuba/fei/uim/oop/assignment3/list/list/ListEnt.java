package sk.stuba.fei.uim.oop.assignment3.list.list;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookResponse;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ListEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<BookResponse> lendingList;

    private boolean lended = false;



}
