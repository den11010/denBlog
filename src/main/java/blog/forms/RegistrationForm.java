package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @Size(min = 2, max = 30, message = "User name should be in range [2...30]")
    private String username;
    @NotNull
    @Size(min = 1, max = 50, message = "Password should be in range[1...50]")
    private String password;
    private String confirmPassword;
    @Size(min = 2, max = 30, message = "Full name should be in range [2...30]")
    private String fullName;


    //--------------------- getters and setters ------------------------

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    //------------------------------------------------------------------
}
