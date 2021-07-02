package org.training360.musicstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstrumentCommand {

    @NotBlank(message = "Brand can not be blank!")
    private String Brand;

    private InstrumentType type;

    @PositiveOrZero(message = "Price must be not negative!")
    private int price;

}
