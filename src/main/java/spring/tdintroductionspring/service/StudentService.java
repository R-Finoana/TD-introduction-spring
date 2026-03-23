package spring.tdintroductionspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.tdintroductionspring.entity.Student;
import spring.tdintroductionspring.repository.StudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getAllStudents(){
        return repository.getStudentsList();
    }

    public List<Student> createStudentList(Student newStudent){
        repository.createStudent(newStudent.getReference(), newStudent.getFirstName(), newStudent.getLastName(), newStudent.getAge());

        return getAllStudents();
    }
}
