import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'summary',
  standalone: true
})
export class CustomPipe implements PipeTransform {

  transform(value: any, limit?:number) {
    if(!value){
      return null;}
    let actuallimit = limit?limit:20
    return value.substr(0,actuallimit)+"..."
  }

}
