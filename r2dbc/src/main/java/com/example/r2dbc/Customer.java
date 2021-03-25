package com.example.r2dbc;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@ToString
public class Customer {
    @Id
    private Long id;

    private final String firstName;

    private final String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
