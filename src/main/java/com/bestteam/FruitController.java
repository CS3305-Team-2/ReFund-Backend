package com.bestteam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    @RequestMapping("/fruit")
    public Fruit fruit() {
        return new Fruit("banana", new String[]{"Not Noah", "Kebab"});
    }
}