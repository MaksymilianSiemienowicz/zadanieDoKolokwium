package com.example.demo.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// 3 zadanie
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDto {

    private Number id;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String email;


}
