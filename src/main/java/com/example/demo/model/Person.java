package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//1 zadanie
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
