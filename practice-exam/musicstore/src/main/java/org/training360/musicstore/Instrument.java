package org.training360.musicstore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {

    private long id;
    private String Brand;
    private InstrumentType type;
    private int price;
    private LocalDate postDate;

    public void setPostDate() {
        this.postDate = LocalDate.now();
    }
}
