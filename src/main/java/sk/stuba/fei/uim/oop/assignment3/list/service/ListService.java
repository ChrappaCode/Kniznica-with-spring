package sk.stuba.fei.uim.oop.assignment3.list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;
import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exeption.BadRequest;
import sk.stuba.fei.uim.oop.assignment3.exeption.NotFound;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListEnt;
import sk.stuba.fei.uim.oop.assignment3.list.list.ListRepository;
import sk.stuba.fei.uim.oop.assignment3.list.web.bodies.ListRequest;

import java.util.List;

@Service
public class ListService implements IListService{

    @Autowired
    private ListRepository repository;

    @Autowired
    private IBookService bookService;

    @Override
    public List<ListEnt> getAllLists() {
        return this.repository.findAll();
    }

    @Override
    public ListEnt createList(){

        ListEnt newList = new ListEnt();

        return this.repository.save(newList);

    }

    @Override
    public ListEnt getListById(Long id) throws NotFound{

        if (this.repository.findListById(id) == null) {
            throw new NotFound();
        }
        return this.repository.findListById(id);
    }

    @Override
    public ListEnt addBookToList(Long id , ListRequest request) throws NotFound, BadRequest {

        ListEnt addList = getListById(id);

        Book addBook = this.bookService.getBookById(request.getId());

        if(addList.isLended() || addList.getLendingList().contains(addBook)){
            throw new BadRequest();
        }

        addList.getLendingList().add(addBook);

        return this.repository.save(addList);
    }

    @Override
    public void lendList(long id) throws NotFound , BadRequest{

        ListEnt listToBeLended = getListById(id);

        if(listToBeLended.isLended()){
            throw new BadRequest();
        }
        for(int i=0;i<listToBeLended.getLendingList().size();i++){
            listToBeLended.getLendingList().get(i).setLendCount(listToBeLended.getLendingList().get(i).getLendCount() + 1);
        }

        listToBeLended.setLended(true);
        this.repository.save(listToBeLended);
    }


    @Override
    public void delete(long id) throws NotFound {
        ListEnt deleteList = this.getListById(id);
        if(deleteList.isLended()){
            for(int i=0;i<deleteList.getLendingList().size();i++){
                deleteList.getLendingList().get(i).setLendCount(deleteList.getLendingList().get(i).getLendCount() - 1);
            }
            deleteList.getLendingList().clear();
        }

        else{
        deleteList.getLendingList().clear();
        this.repository.delete(deleteList);
        }
    }

    @Override
    public void delete(long id , ListRequest request) throws NotFound {
        ListEnt list = this.getListById(id);
        Book book = this.bookService.getBookById(request.getId());
        list.getLendingList().remove(book);
    }

}
