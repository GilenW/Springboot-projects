package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Ana","Ng");
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);

        return ResponseEntity.ok().header("custom-header","Ana").body(student);
    };

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"A","B"));
        studentList.add(new Student(2,"b","b"));
        return ResponseEntity.ok(studentList);
    };

    //url template variable {id}, @PathVariable binds it to url template
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
      Student student = new Student(id, firstName,lastName);
      return ResponseEntity.ok(student);
    };

    //http://localhost:8080/students/query?id=1&firstNam=A&lastName=B
    //Spring boot REST API with request param
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){

      Student student =  new Student(id, firstName, lastName);
      return ResponseEntity.ok(student);
    };

    //Spring boot handles http post request
    //postmapping handle create request, requestbody convert json to java object
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //put request, update existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot rest api that handles http delete request
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentID){
        System.out.println(studentID);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}

