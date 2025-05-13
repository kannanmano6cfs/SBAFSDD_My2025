import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CustomPipe } from '../custom.pipe';

@Component({
  selector: 'app-register',
  imports: [FormsModule,CommonModule,CustomPipe],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  title: string="angular"
  longText: string="Angular is a powerful, open-source framework developed by Google for building dynamic, single-page web applications. It's written in TypeScript and offers a structured approach to web development, simplifying tasks like routing, forms, and client-server communication. Angular is known for its component-based architecture, which promotes code reusability and maintainability"
  onSubmit(data:any){
    console.log(data);
  }
}
