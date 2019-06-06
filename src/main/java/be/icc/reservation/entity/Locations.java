package be.icc.reservation.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * This entity represents the location of a show.
 */
@Entity
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "localities_id")
    private Localities locality;

    @Column(nullable = false)
    private String slug;
    @Column(nullable = false)
    private String designation;
    @Column(nullable = false)
    private String address;
    private String website;
    private String phone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Localities getLocality() {
        return locality;
    }

    public void setLocality(Localities locality) {
        this.locality = locality;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locations locations = (Locations) o;
        return id == locations.id &&
                Objects.equals(locality, locations.locality) &&
                Objects.equals(slug, locations.slug) &&
                Objects.equals(designation, locations.designation) &&
                Objects.equals(address, locations.address) &&
                Objects.equals(website, locations.website) &&
                Objects.equals(phone, locations.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug, designation, address, locality, website, phone);
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", locality=" + locality +
                ", slug='" + slug + '\'' +
                ", designation='" + designation + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getCompleteAddress(){
        return getAddress() + " " + getLocality().getPostalCode() + " "+ getLocality().getLocality();
    }
}
