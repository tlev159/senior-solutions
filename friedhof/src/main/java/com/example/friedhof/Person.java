package com.example.friedhof;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

}
