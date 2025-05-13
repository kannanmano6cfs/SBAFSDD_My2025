import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course',
  imports: [CommonModule],
  templateUrl: './course.component.html',
  styleUrl: './course.component.css'
})
export class CourseComponent implements OnInit {
  courses:Course[]=[];

  constructor(private service:CourseService){}

  ngOnInit(): void {
      this.service.getCourses().subscribe((courses)=>{
        this.courses=courses;
      });
  }
}
