package com.springboot.rest.springboot.rest.rest;

import com.springboot.rest.springboot.rest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StrudentController {
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Pepe", "Percival"));
        theStudents.add(new Student("María Luisa", "Nazaret"));
        theStudents.add(new Student("Jesolu", "Xaviter"));

        return theStudents;
    }
}
