package com.spring.securityjwt.controllers.rest;

import com.spring.securityjwt.pojos.JwtRequest;
import com.spring.securityjwt.pojos.JwtResponse;
import com.spring.securityjwt.services.CustomUserDetailsService;
import com.spring.securityjwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/get-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest.toString());
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Bad Credentials.");
        }
        String token= jwtUtil.generateToken(customUserDetailsService.loadUserByUsername(jwtRequest.getUsername()));
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
