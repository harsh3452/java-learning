package com.harsh.SpringJDBCH2;

import com.harsh.SpringJDBCH2.model.Student;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student student){
        String sql = "INSERT INTO students (id, name, tech) values (?,?,?)";
        int rows = template.update(sql,student.getId(),student.getName(),student.getTech());
        if(rows > 0){
            System.out.printf("Query Successfully");
        }
    }
    public List<Student> findAllStudent(){
        String sql = "select * from students";

        RowMapper rowMapper = new RowMapper() {
            @Override
            public @Nullable Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setTech(rs.getString(3));
                return student;
            }
        };

        List<Student> studentList = template.query(sql,rowMapper);
        return studentList;
    }
}
