package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import lombok.Getter;

@Getter
public class ZvieraOdozva {

    private Long id;

    private String druh;
    private String meno;

    public ZvieraOdozva(Zviera a){
        this.id = a.getId();
        this.druh = a.getDruh();
        this.meno = a.getMeno();
    }

}
