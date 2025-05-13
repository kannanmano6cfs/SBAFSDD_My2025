import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AddTaskComponent } from '../add-task/add-task.component';
import { ListTaskComponent } from '../list-task/list-task.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,AddTaskComponent,ListTaskComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'demoang3';
}
