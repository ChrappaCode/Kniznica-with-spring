package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zvierata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String druh;

}
