package itson.empresariales.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/")
    public String getGreeting() {
        System.out.println("Entro alguien nuevo");
        return "Hola! Estas en el servidor 1";
    }

    @GetMapping("/greeting")
    public String getGreetingWithName(@RequestParam String name) {
        return "Hola, " + name + "!\nTe respondio el servidor 1";
    }
    
}
