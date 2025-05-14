import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule, CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {

  num1: number = 11
  num2: number = 22

  pic1: string ="images\\PurpleBus.jpg"
  altTxt: string = "Image is not available..."

  text: string =""
  message: string =""

  flag: boolean= true

  courses: string[]=[
    "CHENNAI",
    "BANGLORE",
    "HYDERABAD",
    "MUMBAI"
  ]

  showText(){
    this.text="You have entered the purple bus services"
  }

  showCourses(){
    this.flag=true
  }

  hideCourses(){
    this.flag=false
  }
}
