package com.harsh.springfirstapp.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarshController {
    @GetMapping("/")
    public String getInfo(){
        return  "Visited The Abyss";
    }
}
