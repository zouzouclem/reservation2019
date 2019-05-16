package be.icc.reservation.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Shows {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String slug;
    @Column(nullable = false)
    private String title;
    private String posterUrl;
    @OneToOne
    private Locations location;
    @Column(nullable = false)
    private boolean bookable;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Locations getLocationId() {
        return location;
    }

    public void setLocationId(Locations locationId) {
        this.location = locationId;
    }

    public boolean isBookable() {
        return bookable;
    }

    public void setBookable(boolean bookable) {
        this.bookable = bookable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shows shows = (Shows) o;
        return id == shows.id &&
                bookable == shows.bookable &&
                Objects.equals(location, shows.location) &&
                Objects.equals(slug, shows.slug) &&
                Objects.equals(title, shows.title) &&
                Objects.equals(posterUrl, shows.posterUrl) &&
                Objects.equals(description, shows.description) &&
                Objects.equals(price, shows.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, title, posterUrl, location, bookable, price, description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
