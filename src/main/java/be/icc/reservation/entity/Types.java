package be.icc.reservation.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Types {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(mappedBy = "types")
    private Set<Artists> artists;

    @Column(nullable = false)
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Artists> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artists> artists) {
        this.artists = artists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Types types = (Types) o;
        return id == types.id &&
                Objects.equals(type, types.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
