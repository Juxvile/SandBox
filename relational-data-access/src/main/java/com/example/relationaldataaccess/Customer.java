package com.example.relationaldataaccess;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
}
