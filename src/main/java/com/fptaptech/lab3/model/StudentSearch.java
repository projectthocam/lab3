package com.fptaptech.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearch {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
