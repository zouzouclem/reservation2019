package be.icc.reservation.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by Scohier Dorian on 19-04-19.
 */
public class SignupForm {

    @NotBlank(message = "Veuillez mettre un pseudo")
    private String login;
    @NotBlank(message = "Veuillez mettre un mot de passe")
    private String password;
    @NotBlank(message = "Veuillez mettre un prénom" )
    private String firstName;
    @NotBlank(message = "Veuillez mettre un nom" )
    private String lastName;
    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})", message = "Email invalide")
    private String email;
    private String langue;
    private Integer id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}