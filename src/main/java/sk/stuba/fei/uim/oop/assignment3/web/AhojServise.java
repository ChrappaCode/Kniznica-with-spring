package sk.stuba.fei.uim.oop.assignment3.web;

import org.springframework.stereotype.Service;

@Service
public class AhojServise implements IAhojkyServise{

    @Override
    public String urobOdpoved(AhojRequestTelo requestTelo){
        return "hello " + requestTelo.getName();
    }

}
