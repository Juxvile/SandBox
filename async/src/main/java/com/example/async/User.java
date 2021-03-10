package com.example.async;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String blog;

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
