package com.example.exam_spring_sec.controler;


import com.example.exam_spring_sec.dto.UserDto;
import com.example.exam_spring_sec.security.JWTProvider;
import com.example.exam_spring_sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JWTProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {

        UserDetails userDetails = userService.loadUserByUsername(userDto.getUsername());
        String generatedToken = jwtProvider.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(generatedToken);

    }
}
