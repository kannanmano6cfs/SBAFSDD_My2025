import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-main',
  imports: [FormsModule,CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  welcome ="Welcome to the Application"

  num1: number =656
  num2: number =454

  pic1: string = "images\\teamtraining.jpg"
  altText: string = "Image unavailable now..."
  text: string = ""
  message: string=""
  flag: boolean= true

  courses: string[] = [
    "Azure Courses",
    "AWS Courses",
    "Development Courses",
    "Vmware Courses"
  ]

  showText(){
    this.text="Hello Everyone!! Happy Learning!!!"
  }

  showCourses(){
    this.flag=true
  }

  hideCourses(){
    this.flag=false
  }

  height: string ="300px"
  changeheight(){
    if(this.height=="300px")
      this.height="500px"
    else
      this.height="300px"
  }

  classname: string ="class1"
  changeClass()
  {
    if(this.classname=="class1")
      this.classname="class2"
    else
      this.classname="class1"
  }
}
