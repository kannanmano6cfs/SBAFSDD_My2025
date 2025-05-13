import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[]=[
    { id:1,name:'Azure Courses',description:'AZ900 and AZ104',instructor:'Kannan'},
    { id:2,name:'AWS Courses', description:'All AWS Courses',instructor:'Pavan'},
    { id:3,name:"Development Courses", description:'Full Stack Development', instructor:'Kailas'}
  ];

  constructor() { }

  getCourses(){
    return of(this.courses);
  }
}
