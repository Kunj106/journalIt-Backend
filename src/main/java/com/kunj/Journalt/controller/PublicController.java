package com.kunj.Journalt.controller;

import com.kunj.Journalt.entity.User;
import com.kunj.Journalt.service.UserDetailsServiceImpl;
import com.kunj.Journalt.service.UserService;
import com.kunj.Journalt.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Slf4j
public class PublicController
{
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/health-check")
   public String healthCheck(){
       return "All Ok!";
   }

   @PostMapping("/signup")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
   }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken
                    (user.getUserName(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
            String jwt = jwtUtils.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt , HttpStatus.OK) ;
        } catch (Exception e){
          log.error("Exception occurred while createAuthenticationToken",e);
          return new ResponseEntity<>("Incorrect username or passowrd",HttpStatus.BAD_REQUEST);
        }
    }
}
