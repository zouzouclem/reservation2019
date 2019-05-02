package be.icc.reservation.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

/**
 * Created by Scohier Dorian on 19-04-19.
 */
public class SignupForm {

    @NotBlank(message = "Veuillez mettre un pseudo")
    private String login;
    @NotBlank(message = "Veuillez mettre un mot de passe")
    @Pattern(regexp = "^(?=.*[$&+,:;=?@#|'<>.^*()%!-])(?=.*[A-Z]).{6,}$", message = "Veuillez mettre un mot de passe comportant au moins une majuscule, un caractère spécial et qui a une taille d'au moins 6 caractères")
    private String password;
    @NotBlank(message = "Veuillez confirmer le mot de passe")
    private String passwordCheck;
    @NotBlank(message = "Veuillez mettre un prénom" )
    private String firstName;
    @NotBlank(message = "Veuillez mettre un nom" )
    private String lastName;
    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})", message = "Email invalide")
    private String email;
    private String langue;
    private Integer id;
    private boolean isPasswordMatch;

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

    public void setPasswordMatch(boolean passwordMatch) {
        isPasswordMatch = passwordMatch;
    }

    @AssertTrue(message = "Le mot de passe n'est pas le même")
    public boolean getIsPasswordMatch() {
        if(password==null||passwordCheck==null){
            isPasswordMatch = false;
        }else{
            isPasswordMatch = password.equals(passwordCheck);
        }
        return  isPasswordMatch;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
}