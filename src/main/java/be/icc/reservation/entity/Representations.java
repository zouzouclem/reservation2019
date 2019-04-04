package be.icc.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Representations {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "show_id", nullable = false)
    private int showId;

    @Column(name = "location_id", nullable = false)
    private int locationId;

    @Column(nullable = false)
    private Timestamp whenDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Timestamp getWhenDate() {
        return whenDate;
    }

    public void setWhenDate(Timestamp whenDate) {
        this.whenDate = whenDate;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Representations that = (Representations) o;
        return id == that.id &&
                showId == that.showId &&
                locationId == that.locationId &&
                Objects.equals(whenDate, that.whenDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, showId, whenDate, locationId);
    }
}
