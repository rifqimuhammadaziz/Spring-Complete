package rifqimuhammadaziz.springcomplete.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World Controller its works Rifqi!";
    }
}
