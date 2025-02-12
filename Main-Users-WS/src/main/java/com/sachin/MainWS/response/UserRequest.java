package com.sachin.MainWS.response;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest
{
    @NotNull(message="First Name cannot be Null.")
    @Size(min=2, message = "First name must be atleast 2 characters.")
    private String firstName;

    @NotNull(message="Last Name cannot be Null.")
    @Size(min=2, message = "Last name must be atleast 2 characters.")
    private String lastName;
    @NotNull(message="Email cannot be Null.")
    @Email
    private String email;
    @NotNull(message="Password cannot be Null.")
    @Size(min=8, max=16, message = "Password length between 8 and 16.")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
