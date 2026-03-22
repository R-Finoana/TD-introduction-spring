package spring.tdintroductionspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.tdintroductionspring.entity.Student;
import spring.tdintroductionspring.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<String> getStudents(@RequestHeader(value= HttpHeaders.ACCEPT, defaultValue = MediaType.TEXT_PLAIN_VALUE) String student){

        if(!student.contains("text/plain")){
            return ResponseEntity.status(415)
                    .body("Unsupported format");
        }

        List<Student> students = service.getAllStudents();

        String body = students.stream()
                .map(std -> std.getFirstName()+" "+std.getLastName())
                .collect(Collectors.joining("\n"));

        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(body);
    }
}
