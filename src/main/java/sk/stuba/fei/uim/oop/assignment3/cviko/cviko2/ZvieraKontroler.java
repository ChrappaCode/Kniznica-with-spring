package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zviera")
public class ZvieraKontroler {

    @Autowired
    private IZvieraciServise servise;

    @GetMapping("/hello")
    public String hello(){
        return "HELLO WORLD";
    }

    @GetMapping()
    public List<ZvieraOdozva> getVsetkyZvierata(){
        return this.servise.getAll().stream().map(ZvieraOdozva::new).collect(Collectors.toList()); //zviera -> new ZvieraOdozva(zviera)
    }

}
