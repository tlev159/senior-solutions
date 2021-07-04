package com.example.friedhof;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlotCommand {

    @NonNull
    private String plotId;

    private String nameOfLeaseholder;
    private List<Person> people = new ArrayList<>();
    private LocalDate dateOfRedemption;
    private LocalDate dateOfExpiration;

}
