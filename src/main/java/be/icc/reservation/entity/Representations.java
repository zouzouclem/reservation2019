package be.icc.reservation.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
public class Representations {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "representation_user",
            joinColumns = {@JoinColumn(name = "representation_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<Users> users;

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

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
