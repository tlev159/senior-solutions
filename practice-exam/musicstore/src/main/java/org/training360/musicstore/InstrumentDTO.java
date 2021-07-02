package org.training360.musicstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDTO {

    private long id;
    private String Brand;
    private InstrumentType type;
    private int price;
    private LocalDate postDate;

}
