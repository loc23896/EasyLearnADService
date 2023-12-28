package com.easy.learn.dto.Student;

import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends ResponseDTO<Student> {
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String address;
    private String phone;
    private String classId;
    private Long memberManagermentId;
}