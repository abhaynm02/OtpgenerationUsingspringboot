package com.registerApp.EmailVerification.service;

import com.registerApp.EmailVerification.Dto.RegisterDto;
import com.registerApp.EmailVerification.DtoLogin.LoginDto;
import com.registerApp.EmailVerification.Entity.User;
import com.registerApp.EmailVerification.repository.UserRepository;
import com.registerApp.EmailVerification.util.EmailUtil;
import com.registerApp.EmailVerification.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalTime;

@Service
public class UserService {
    @Autowired
    private EmailUtil emailUtil;

   @Autowired
   private UserRepository userRepository;
    @Autowired
    private OtpUtil otpUtil;
    public String register(RegisterDto registerDto) {
        String otp=otpUtil.generateOtp();
        User user = new User();
        emailUtil.sendOtpEmail(registerDto.getEmail(),otp);
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        user.setOtp(otp);
        user.setOtpGenerateTime(LocalTime.now());
        userRepository.save(user);
        return "user register is successful";

    }

    public String verifyAccount(String email, String otp) {
        User user =userRepository.findByEmail(email);
       if (user==null){
          return "user note found";
       }
       if (user.getOtp().equals(otp)&& Duration.between(user.getOtpGenerateTime(),LocalTime.now()).getSeconds()<(2*60)){
           user.setActive(true);
           userRepository.save(user);
           return "verify successful";
       }
       return "otp time is expire";
    }

    public String regenerateOtp(String email) {
        User user =userRepository.findByEmail(email);
        System.out.println(user.getEmail());
        if (user==null){
            return "user email note found please check the email";
        }
        String otp=otpUtil.generateOtp();
        emailUtil.sendOtpEmail(email,otp);
        user.setOtp(otp);
        user.setOtpGenerateTime(LocalTime.now());
        user.setRoll("user");
        userRepository.save(user);
        return "Email send please verify with in one minuet";

    }

    public String login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        System.out.println(user.getEmail());
        if (user==null){
           return "user note found";
        }
        if (!loginDto.getPassword().equals(user.getPassword())){
            return "password id incorrect";
        } else if (!user.isActive()) {
            return "your account is not verified";

        }
        return "login successfully";
    }
}
