package com.spring.securityjwt.pojos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JwtResponse {
    private String token;
}
