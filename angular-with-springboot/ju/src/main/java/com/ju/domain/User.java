package com.ju.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@Document(collection = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Field("_id")
    @JsonIgnore
    private String id;

    private String username;

    private String password;

    private String email;

}
