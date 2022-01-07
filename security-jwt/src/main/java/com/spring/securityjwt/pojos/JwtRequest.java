package com.spring.securityjwt.pojos;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
@ToString
public class JwtRequest {
    private String email;
    private String password;
}
