package com.LearnJPA.JPA.Hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesJdbcRepositary {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private String insertStatement =
            """
            INSERT INTO course(id, name, author)
            VALUES (1, 'Spring Boot', 'Udemy')
            
            """;
    private String insertStatementCust =
            """
            INSERT INTO course(id, name, author)
            VALUES (?, ?, ?)
            
            """;

    private String deleteCourseById =
            """
            DELETE from course where id = ?
            
            """;

    private String SELECT_QUERY =
            """
            select * from course where id = ?
            
            """;

    public void insertData(){
        springJdbcTemplate.update(insertStatement);
    }

    public void insertDataWithCustomData(Course course){
        springJdbcTemplate.update(insertStatementCust, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteCourse(long id){
        springJdbcTemplate.update(deleteCourseById, id);
    }

    public Course selectById(long id){
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
