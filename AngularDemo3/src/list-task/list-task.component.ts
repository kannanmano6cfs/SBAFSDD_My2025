import { Component } from '@angular/core';
import { TaskService } from '../services/task.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-task',
  imports: [CommonModule],
  templateUrl: './list-task.component.html',
  styleUrl: './list-task.component.css'
})
export class ListTaskComponent {
  localItems:string[]=[]

  constructor(private service:TaskService){
    this.localItems=this.service.getItems()
  }

}
