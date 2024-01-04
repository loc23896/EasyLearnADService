package com.easy.learn.dto.TrainerMember;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date dateCreated;
    private String status;
}
