package com.example.friedhof;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotDTO {

    private long id;
    private String plotId;
    private String nameOfLeaseholder;
    private List<Person> people = new ArrayList<>();
    private LocalDate dateOfRedemption;
    private LocalDate dateOfExpiration;

}
