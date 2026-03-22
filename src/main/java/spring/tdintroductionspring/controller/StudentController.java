package spring.tdintroductionspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.tdintroductionspring.entity.Student;
import spring.tdintroductionspring.service.StudentService;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public List<Student> createStudent(@RequestBody Student student){
        try{
            return service.createStudentList(student);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
