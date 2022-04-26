package sk.stuba.fei.uim.oop.assignment3.list.list;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookResponse;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private java.util.List<BookResponse> lendingList;

    private boolean lended = false;



}
