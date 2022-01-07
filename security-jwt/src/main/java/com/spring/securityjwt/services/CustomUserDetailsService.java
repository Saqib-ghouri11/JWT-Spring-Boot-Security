package com.spring.securityjwt.services;

import com.spring.securityjwt.pojos.UserDto;
import com.spring.securityjwt.repos.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import  com.spring.securityjwt.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email);
        if(user!=null) {
            //this will return user from database
            return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword())
                    .disabled(false).authorities(user.getRole()).build();
        }
        else{
            throw new UsernameNotFoundException("Invalid Credentials");
        }
    }

    public User getUserById(Integer id){
        User user=new User();
        try {
           user= userRepository.findById(id).get();
        }catch (Exception e){e.printStackTrace();}
        return user;
    }

    public List<User> getUsers(){
        List<User> users=new ArrayList<>();
        try {
            users= userRepository.findAll();
        }catch (Exception e){e.printStackTrace();}
        return users;
    }

    public User addUser(UserDto userDto){
        User user=null;
        if(userDto!=null){
            user=userRepository.findByEmail(userDto.getEmail());
            if(user!=null){
                throw new EntityExistsException("User with this email alreary exist.");
            }
            user=new User();
            BeanUtils.copyProperties(userDto,user);
            userRepository.save(user);
        }
        return user;
    }

    public User deleteUser(Integer id){
        User user;
        user=userRepository.findById(id).get();
        try{
            if(user!=null){
                userRepository.deleteById(id);
            }
        }catch (Exception e){e.printStackTrace();}
        return user;
    }
}
