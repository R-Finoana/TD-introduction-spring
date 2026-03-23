package spring.tdintroductionspring.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.tdintroductionspring.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudentsList(){
        return students;
    }

    public List<Student> createStudents(List<Student> newStudents){
        students.addAll(newStudents);
        return students;
    }
}
