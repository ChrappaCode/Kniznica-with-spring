package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZvieraciServise implements IZvieraciServise{

    @Autowired
    private ZvieraciRepo repozitar;

    @Autowired
    public ZvieraciServise(ZvieraciRepo repozitar) {
        this.repozitar = repozitar;
        Zviera a1 = new Zviera();
        a1.setDruh("Marha");
        a1.setMeno("Dusan Cinkota");
        this.repozitar.save(a1);
        Zviera a2 = new Zviera();
        a2.setDruh("Algebraicky pes");
        a2.setMeno("Oto Wagner");
        System.out.println(a2.getId());
        a2 = this.repozitar.save(a2);
        System.out.println(a2.getId());
        //this.repozitar.delete(a2);
    }

    @Override
    public List<Zviera> getAll() {
        return this.repozitar.findAll();
    }

    @Override
    public Zviera vyrob(ZvieraRequest request) {
        Zviera noveZviera = new Zviera();
        noveZviera.setDruh(request.getDruh());
        noveZviera.setMeno(request.getMeno());
        return this.repozitar.save(noveZviera);
    }


    @Override
    public List<Zviera> getAllByName(String meno) {
        return this.repozitar.findByMeno(meno);
    }


}
