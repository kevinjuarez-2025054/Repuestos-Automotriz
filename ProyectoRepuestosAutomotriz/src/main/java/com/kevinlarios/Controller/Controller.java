package com.kevinlarios.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping ("/Controller")
    public String hola(){
        return "hola mundo";
    }
}
