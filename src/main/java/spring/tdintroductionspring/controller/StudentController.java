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

    @PostMapping("/students")
    public ResponseEntity<List<Student>> createStudent(@RequestBody List<Student> newStudents){
        try{
            List<Student> allStudents = service.createStudentList(newStudents);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(allStudents);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(@RequestHeader(value= HttpHeaders.ACCEPT, required = false) String accept){

        List<Student> students = service.getAllStudents();

        if(accept == null){
            return ResponseEntity.status(400).build();
        } else if(!accept.contains("text/plain") && !accept.contains("application/json")) {
            return ResponseEntity.status(501).build();
        }
        return ResponseEntity.ok().body(students);
    }
}
