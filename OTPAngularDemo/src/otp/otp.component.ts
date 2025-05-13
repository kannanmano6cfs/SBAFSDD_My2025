import { Component } from '@angular/core';
import { OtpService } from '../services/otp.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-otp',
  imports: [FormsModule, CommonModule],
  templateUrl: './otp.component.html',
  styleUrl: './otp.component.css'
})
export class OtpComponent {
  email: string ='';
  otp: string = '';
  otpSent: boolean=false;
  message: string='';
  success: boolean = false;
  
  constructor(private service:OtpService){}

  requestOtp(){
    this.service.sendOtp(this.email).subscribe({     
      next: (response) => {
        this.otpSent=true;
        this.message =response.message;
        this.success=true;
      },
      error:() =>{
        this.message="Failed to send OTP";
        this.success=false;
      }
    });
  }

  verifyOtp(){
    this.service.verifyOtp(this.email,this.otp).subscribe({
      next: (response) =>{
        this.message=response.message;
        this.success=true;
      },
      error: () =>{
        this.message="Invalid OTP";
        this.success=false;
      }
    })
  }
}
