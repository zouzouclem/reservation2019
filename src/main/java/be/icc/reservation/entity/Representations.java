package be.icc.reservation.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
public class Representations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "representation_user",
            joinColumns = {@JoinColumn(name = "representation_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<Users> users;

    @ManyToOne
    private Shows show;

    @ManyToOne
    private Locations location;

    @Column(nullable = false)
    private Timestamp whenDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Representations that = (Representations) o;
        return id == that.id &&
                show.getId() == that.show.getId() &&
                location.getId() == that.location.getId() &&
                Objects.equals(whenDate, that.whenDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, show.getId(), whenDate, location.getId());
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
