package be.icc.reservation.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Shows {
    private int id;
    private String slug;
    private String title;
    private String posterUrl;
    private int locationId;
    private byte bookable;
    private BigDecimal price;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "poster_url")
    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Basic
    @Column(name = "location_id")
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "bookable")
    public byte getBookable() {
        return bookable;
    }

    public void setBookable(byte bookable) {
        this.bookable = bookable;
    }

    @Basic
    @Column(name = "price")
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
                locationId == shows.locationId &&
                bookable == shows.bookable &&
                Objects.equals(slug, shows.slug) &&
                Objects.equals(title, shows.title) &&
                Objects.equals(posterUrl, shows.posterUrl) &&
                Objects.equals(price, shows.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, title, posterUrl, locationId, bookable, price);
    }
}
