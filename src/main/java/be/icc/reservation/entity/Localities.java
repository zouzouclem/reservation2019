package be.icc.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * This entity represents localities such as 1000 Brussel. Those combinations are uniques.
 */
@Entity
public class Localities {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String locality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localities that = (Localities) o;
        return id == that.id &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(locality, that.locality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postalCode, locality);
    }
}
