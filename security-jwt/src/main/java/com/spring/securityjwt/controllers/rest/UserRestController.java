package com.spring.securityjwt.controllers.rest;

import com.spring.securityjwt.entities.User;
import com.spring.securityjwt.pojos.UserDto;
import com.spring.securityjwt.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public List<User> getAll(){
        return customUserDetailsService.getUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id){
        return customUserDetailsService.getUserById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody @Valid UserDto userDto){
        return customUserDetailsService.addUser(userDto);
    }

    @DeleteMapping("delete/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        return customUserDetailsService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }
}
