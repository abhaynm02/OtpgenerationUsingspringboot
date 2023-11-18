package com.registerApp.EmailVerification.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  long id;
    private  String name;
    private  String email;
    private String password;
    private  String roll;
    private  boolean active;
    private  String otp;
    private LocalTime otpGenerateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalTime getOtpGenerateTime() {
        return otpGenerateTime;
    }

    public void setOtpGenerateTime(LocalTime otpGenerateTime) {
        this.otpGenerateTime = otpGenerateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roll='" + roll + '\'' +
                ", active=" + active +
                ", otp='" + otp + '\'' +
                ", otpGenerateTime=" + otpGenerateTime +
                '}';
    }

    public User( String name, String email, String password, String roll, boolean active, String otp, LocalTime otpGenerateTime) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.roll = roll;
        this.active = active;
        this.otp = otp;
        this.otpGenerateTime = otpGenerateTime;
    }

    public User() {
    }
}
