package spring.tdintroductionspring.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name){
        if(name == null || name.trim().isEmpty()){
            return ResponseEntity.badRequest().body("Name is required");
        }
        return ResponseEntity.ok("Welcome "+name);
    }
}
