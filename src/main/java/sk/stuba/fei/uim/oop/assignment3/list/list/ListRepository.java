package sk.stuba.fei.uim.oop.assignment3.list.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.uim.oop.assignment3.book.book.Book;

import java.util.List;

@Repository
@RequestMapping("/list")
public interface ListRepository extends JpaRepository<ListEnt, Long> {

    List<ListEnt> findAll();
    ListEnt findBookById(Long id);

}
