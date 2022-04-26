package sk.stuba.fei.uim.oop.assignment3.list.web;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.book.web.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListEnt;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ListResponse {

    private final Long id;

    private final List<BookResponse> lendedList;
    private boolean lended;


    public ListResponse(ListEnt list){

        this.id = list.getId();
        this.lendedList = list.getLendingList().stream().map(BookResponse::new).collect(Collectors.toList());
        this.lended = list.isLended();

    }


}
