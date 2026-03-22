package spring.tdintroductionspring.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.tdintroductionspring.entity.Student;

import java.util.List;

@Repository
@AllArgsConstructor
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Student> getStudentsList(){
        String sql= """
                SELECT reference, first_name, last_name, age
                FROM student
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student std = new Student();
            std.setReference(rs.getString("reference"));
            std.setFirstName(rs.getString("first_name"));
            std.setLastName(rs.getString("last_name"));
            std.setAge(rs.getInt("age"));

            return std;
        });
    }
}
