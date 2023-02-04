package com.LearnJPA.JPA.Hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoursesJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CoursesJdbcRepositary coursesJdbcRepositary;


    @Override
    public void run(String... args) throws Exception {
        coursesJdbcRepositary.insertData();
        coursesJdbcRepositary.insertDataWithCustomData(new Course(2,"UI", "Udemy"));
        coursesJdbcRepositary.insertDataWithCustomData(new Course(3,"UI", "Udemy"));
        coursesJdbcRepositary.insertDataWithCustomData(new Course(4,"UI", "Udemy"));
        coursesJdbcRepositary.deleteCourse(4);

        System.out.println(coursesJdbcRepositary.selectById(2));
    }
}
