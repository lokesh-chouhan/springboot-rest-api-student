package com.udemy.springbootrestapi.controller;

import com.udemy.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent()
    {
        Student student = new Student("Lokesh", "Chouhan", 1);
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents()
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tejas", "Chouhan", 1));
        students.add(new Student("Ekta", "Chouhan", 2));
        students.add(new Student("Gennie", "Chouhan", 3));
        students.add(new Student("Lokesh", "Chouhan", 4));
        return students;
    }

    @GetMapping("student/{id}")
    public Student getStudentPathVariable(@PathVariable int id){
        return new Student("Lokesh", "Chouhan", id);
    }


    @GetMapping("student/query")
    public Student getStudentQueryParam(@RequestParam int id)
    {
        return new Student("Lokesh", "Chouhan", id);
    }

    @PostMapping("student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student s)
    {
        System.out.println("Student is = "+s.getFirstName()+" "+s.getLastName()+" "+s.getId());
        return s;
    }

    @PutMapping("student")
    public Student updateStudent(@RequestBody Student s)
    {
        System.out.println("Student is = "+s.getFirstName()+" "+s.getLastName()+" "+s.getId());
        return s;
    }
}
