package com.example.studentManagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;

    @NotEmpty(message = "Student first name should not be empty")
    private String firstName;
    @NotEmpty(message = "Student last name should not be empty")
    private String lastName;
    @NotEmpty(message = "Student emaul should not be empty")
    @Email
    private String email;

}