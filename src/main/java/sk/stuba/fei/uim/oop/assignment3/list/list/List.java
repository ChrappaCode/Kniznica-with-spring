package sk.stuba.fei.uim.oop.assignment3.list.list;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
