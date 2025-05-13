import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-add-task',
  imports: [FormsModule,CommonModule],
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.css'
})
export class AddTaskComponent {

  //DependencyInjection for services (Singleton object)
  constructor(private service:TaskService){}

  onSubmit(data:any){
    this.service.addItem(data.value.item);
    data.reset()
  }
}
