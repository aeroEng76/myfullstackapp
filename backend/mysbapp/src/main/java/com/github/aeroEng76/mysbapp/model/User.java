package com.github.aeroEng76.mysbapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private String emailAddress;

}
