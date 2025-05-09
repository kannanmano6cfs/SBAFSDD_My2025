package com.learning.otpapiapp.Service;

import com.learning.otpapiapp.Model.OtpData;
import com.learning.otpapiapp.Repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class verificationService {

    @Autowired
    private OtpRepository otpRepository;

    //Send OTP
    public String sendOtp(String email){
        String otp=String.format("%06d", new Random().nextInt(999999));
        OtpData otpData=new OtpData(email,otp);
        otpRepository.save(otpData);
        return "OTP "+otp+" sent successfully";
    }

    //Verify OTP
    public String verifyOtp(String email,String otp){
        Optional<OtpData> otpData=otpRepository.findByEmail(email);
        if(otpData.isPresent()){
            OtpData otpData1=otpData.get();
            if(otpData1.getOtp().equals(otp)){
                return "OTP verified successfully";
            }
        }
        return "Invalid OTP";
    }
}
