package cars;

import java.time.LocalDate;

public class KmState {

    private LocalDate localDate;
    private int kmState;

    public KmState(LocalDate localDate, int kmState) {
        this.localDate = localDate;
        this.kmState = kmState;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getKmState() {
        return kmState;
    }
}
