package be.icc.reservation.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

/**
 * Created by Scohier Dorian on 19-04-19.
 */
public class SignupForm {

    @NotBlank(message = "{error.connect.username}")
    private String login;
    @NotBlank(message = "{error.connect.password}")
    @Pattern(regexp = "^(?=.*[$&+,:;=?@#|'<>.^*()%!-])(?=.*[A-Z]).{6,}$", message = "{error.connect.passwordFormat}")
    private String password;
    @NotBlank(message = "{error.connect.passwordMatch}")
    private String passwordCheck;
    @NotBlank(message = "{error.connect.lastName}" )
    private String firstName;
    @NotBlank(message = "{error.connect.firstName}" )
    private String lastName;
    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})", message = "{error.connect.mail}")
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

    @AssertTrue(message = "{error.connect.passwordNotMatch}")
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