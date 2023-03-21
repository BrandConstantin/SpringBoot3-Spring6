package com.springboot.rest.springboot.rest.rest;

import com.springboot.rest.springboot.rest.entity.Student;
import com.springboot.rest.springboot.rest.exceptionresponse.StudentErrorResponse;
import com.springboot.rest.springboot.rest.exceptionresponse.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StrudentController {
    private List<Student> theStudents;

    // define @PostConstruct lo load the student data only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Pepe", "Percival"));
        theStudents.add(new Student("María Luisa", "Nazaret"));
        theStudents.add(new Student("Jesolu", "Xaviter"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        // check the object exist
        if((id >= theStudents.size()) || (id < 0)){
            throw new StudentNotFoundException("Student id not found - " + id);
        }
        // index the list
        return theStudents.get(id);
    }

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create a error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        // create a error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage()); // se puede cambiar con mensaje personalizado
        error.setTimeStamp(System.currentTimeMillis());

        // return entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}