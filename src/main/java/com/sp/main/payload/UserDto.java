package com.sp.main.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotNull(message = "name is not provide null")
    @Size(min = 2 , max = 10 , message = "name should be provided 2 characters to 10 charecter")
    private String name;
    @Email(message = "should be provide valid email")
    private String email;

}
