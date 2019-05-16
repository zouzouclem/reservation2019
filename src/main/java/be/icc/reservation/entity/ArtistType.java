package be.icc.reservation.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ArtistType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Artists artist;

    @OneToOne
    private Types type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "artist_type_show",
            joinColumns = {@JoinColumn(name = "artist_type_id")},
            inverseJoinColumns = {@JoinColumn(name = "show_id")}
    )
    private Set<Shows> shows;

    public int getId() {
        return id;
    }

    public Artists getArtist() {
        return artist;
    }

    public void setArtist(Artists artist) {
        this.artist = artist;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Set<Shows> getShows() {
        return shows;
    }

    public void setShows(Set<Shows> shows) {
        this.shows = shows;
    }
}
