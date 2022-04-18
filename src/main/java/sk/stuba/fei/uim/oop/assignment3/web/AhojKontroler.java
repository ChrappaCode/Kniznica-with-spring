package sk.stuba.fei.uim.oop.assignment3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class AhojKontroler {

    private int pocitadlo = 0;

    @GetMapping(value = "/ahoj")
    public String ahoj(){
        return "ahoj " + (this.pocitadlo++);
    }

    @GetMapping(value = "/param")
    public String ahojParameter(@RequestParam(name = "name" , defaultValue = "skap") String meno){

        return "ahoj " + meno;

    }

    @GetMapping(value = "/path/{name}")
    public String ahojPathParameter(@PathVariable("name") String meno){

        return "ahoj " + meno;

    }

}
