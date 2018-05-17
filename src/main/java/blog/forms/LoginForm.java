package blog.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The LoginForm holds the validation rules for the form fields
 * */

public class LoginForm {

    @Size(min = 2, max = 30, message = "User name should be in range [2...30]")
    private String username;

    @NotNull
    @Size(min = 1, max = 50) // good luck remembering 50 symbols... unless it a rhyme
    private String password;

    //--------------------- getters and setters -----------------------
    public String getUsername(){
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
    //------------------------------------------------------------------
}
