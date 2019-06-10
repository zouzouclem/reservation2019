package be.icc.reservation.form;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class RepresentationForm {

    private int location;

    private int show;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{error.representation.date}")
    @Future(message = "{error.representation.futur}")
    Date whenDate;

    @NotBlank(message = "{error.representation.time}")
    String whenTime;

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Date getWhenDate() {
        return whenDate;
    }

    public void setWhenDate(Date whenDate) {
        this.whenDate = whenDate;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public String getWhenTime() {
        return whenTime;
    }

    public void setWhenTime(String whenTime) {
        this.whenTime = whenTime;
    }
}