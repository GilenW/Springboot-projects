package com.example.studentManagement.service.Impl;

import com.example.studentManagement.dto.StudentDto;
import com.example.studentManagement.entity.Student;
import com.example.studentManagement.mapper.StudentMapper;
import com.example.studentManagement.repository.StudentRepository;
import com.example.studentManagement.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }
}