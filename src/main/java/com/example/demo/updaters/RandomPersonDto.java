package com.example.demo.updaters;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RandomPersonDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
