package com.sachin.MainWS.response;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserUpdate
{
    @NotNull(message="First Name cannot be Null.")
    @Size(min=2, message = "First name must be atleast 2 characters.")
    private String firstName;

    @NotNull(message="Last Name cannot be Null.")
    @Size(min=2, message = "Last name must be atleast 2 characters.")
    private String lastName;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
