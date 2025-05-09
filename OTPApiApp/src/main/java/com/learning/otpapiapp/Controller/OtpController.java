package com.learning.otpapiapp.Controller;

import com.learning.otpapiapp.Service.verificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//For Angular Front End Communication
//@CrossOrigin(origins="http://localhost::4200")
public class OtpController {

    @Autowired
    private verificationService service;

    //send OTP
    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String email){
        service.sendOtp(email);
        return ResponseEntity.ok("OTP sent successfully");
    }

    //Verify OTP
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp){
        String msg=service.verifyOtp(email,otp);
        return ResponseEntity.ok(msg);
    }
}
