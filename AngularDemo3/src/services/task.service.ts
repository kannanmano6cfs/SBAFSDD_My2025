import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private items: string[]=[] //Share this data
  constructor() { }

  addItem(item:string)  {
    this.items.push(item)
    console.log(this.items);
  }

  getItems(): string[]{
    return this.items;
  }
}
