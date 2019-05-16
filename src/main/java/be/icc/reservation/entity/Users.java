package be.icc.reservation.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "roles_id")
    private Roles role;

    @ManyToMany(mappedBy = "users")
    private Set<Representations> representations;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String langue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<Roles> getAuthorities() {
        return Arrays.asList(getRole());
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) &&
                Objects.equals(firstname, users.firstname) &&
                Objects.equals(lastname, users.lastname) &&
                Objects.equals(email, users.email) &&
                Objects.equals(langue, users.langue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstname, lastname, email, langue);
    }

    public Set<Representations> getRepresentations() {
        return representations;
    }

    public void setRepresentations(Set<Representations> representations) {
        this.representations = representations;
    }
}
