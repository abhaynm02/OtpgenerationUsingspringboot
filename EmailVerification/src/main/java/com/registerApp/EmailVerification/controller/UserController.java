package com.registerApp.EmailVerification.controller;

import com.registerApp.EmailVerification.Dto.RegisterDto;
import com.registerApp.EmailVerification.DtoLogin.LoginDto;

import com.registerApp.EmailVerification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        return  new ResponseEntity<>(userService.register(registerDto), HttpStatus.OK);
    }
    @PostMapping("/verify-account")
    public  ResponseEntity<String>verifyAccount(@RequestParam String email,@RequestParam String otp){
        return  new ResponseEntity<>(userService.verifyAccount(email,otp),HttpStatus.OK);
    }
    @PostMapping("/regenerate-otp")
    public  ResponseEntity<String> regeneratePtp(@RequestParam String email){
        return new ResponseEntity<>(userService.regenerateOtp(email),HttpStatus.OK);
    }
    @PostMapping("/login")
    public  ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(userService.login(loginDto),HttpStatus.OK);
    }

}
