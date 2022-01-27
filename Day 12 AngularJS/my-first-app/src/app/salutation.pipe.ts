import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'salutation'
})
export class SalutationPipe implements PipeTransform {

  transform(value: string,gender: string): string {
    if(gender == "Male"){
      return "Mr. "+value;
    }
    else{
      return "Ms. "+value;
    }
  }

}
