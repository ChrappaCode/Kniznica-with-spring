package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{meno}")
    public List<ZvieraOdozva> getVsetkyZvierataPodlaMena(@PathVariable("meno") String meno){
        return this.servise.getAllByName(meno).stream().map(ZvieraOdozva::new).collect(Collectors.toList()); //zviera -> new ZvieraOdozva(zviera)
    }

    @PostMapping()
    public ZvieraOdozva pridajZviera(@RequestBody ZvieraRequest request){
        return new ZvieraOdozva(this.servise.vyrob(request));
    }

}
