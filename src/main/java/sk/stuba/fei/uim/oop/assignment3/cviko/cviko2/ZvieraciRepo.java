package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZvieraciRepo extends CrudRepository<Zviera, Long> {

    List<Zviera> findAll();

    List<Zviera> findByMeno(String meno);

}
