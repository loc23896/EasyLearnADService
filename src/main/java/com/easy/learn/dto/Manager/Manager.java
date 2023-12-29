package com.easy.learn.dto.Manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String managementType;
}
