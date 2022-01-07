package com.spring.securityjwt.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Integer id;

    @NotEmpty(message = "username can not be null or empty")
    @NotNull
    private String username;
    @NotEmpty(message = "email can not be null or empty")
    @NotNull
    @Email(message = "email must be in fromat 'email@example.com'")
    private String email;
    @NotNull
    @NotEmpty(message = "password can not be null or empty")
    private String password;
    @NotEmpty
    @NotNull
    private String role="ROLE_NORMAL";

}
