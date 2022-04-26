package sk.stuba.fei.uim.oop.assignment3.list.web;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListEnt;

import java.util.List;

@Data
public class ListResponse {

    private final Long id;

    private final List<Book> lendedList;
    private boolean lended;


    public ListResponse(ListEnt list){

        this.id = list.getId();
        this.lendedList = list.getLendingList();
        this.lended = list.isLended();

    }


}
