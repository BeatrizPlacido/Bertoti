package  com.example.demo.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")

public class HomeResource {

    @GetMapping
    public String getHello() {
        return "Deu bom!!";
    }
}


