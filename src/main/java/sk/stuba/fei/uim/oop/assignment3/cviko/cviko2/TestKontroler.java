package sk.stuba.fei.uim.oop.assignment3.cviko.cviko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zviera")
public class TestKontroler {

    @Autowired
    private IZvieraciServise servise;

    @GetMapping("/hello")
    public String hello(){
        return "HELLO WORLD";
    }

}
