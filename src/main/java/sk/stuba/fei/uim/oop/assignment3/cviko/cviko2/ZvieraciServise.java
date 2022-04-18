package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZvieraciServise implements IZvieraciServise{

    @Autowired
    private ZvieraciRepo repozitar;

}
