package com.learning.otpapiapp.Controller;

import com.learning.otpapiapp.Service.verificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//For Angular Front End Communication
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class OtpController {

    @Autowired
    private verificationService service;

    //send OTP
    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendOtp(@RequestParam String email){
//        service.sendOtp(email);
//        return ResponseEntity.ok("OTP sent successfully");

        Map<String, String> response = new HashMap<>();
        response.put("message", "OTP sent successfully");
        service.sendOtp(email);
        return ResponseEntity.ok(response);
    }

    //Verify OTP
    @PostMapping("/verify")
    public ResponseEntity<Map<String,String>> verifyOtp(@RequestParam String email, @RequestParam String otp){
        Map<String, String> response = new HashMap<>();

        String msg=service.verifyOtp(email,otp);
        response.put("message", msg);

        return ResponseEntity.ok(response);
    }
}
