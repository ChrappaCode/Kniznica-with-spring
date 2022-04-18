package sk.stuba.fei.uim.oop.assignment3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AhojKontroler {

    @GetMapping("/ahoj")
    public String ahoj(){
        return "ahoj";
    }

}
