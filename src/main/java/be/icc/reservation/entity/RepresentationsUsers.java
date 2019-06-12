package be.icc.reservation.entity;

import javax.persistence.*;

@Entity
public class RepresentationsUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Representations representation;

    @ManyToOne
    private Users user;

    private int places;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Representations getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representations representation) {
        this.representation = representation;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
