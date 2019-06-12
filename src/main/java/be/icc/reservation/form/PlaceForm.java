package be.icc.reservation.form;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.File;

public class PlaceForm {


    @NotNull(message = "{error.common.price}")
    @NumberFormat(style= NumberFormat.Style.NUMBER)
    @Min(1)
    private int place;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
