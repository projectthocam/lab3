package com.fptaptech.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private SiteClass siteClass;
    @ManyToOne
    @JoinColumn(name = "id_file")
    private FileStore fileStore;
}
