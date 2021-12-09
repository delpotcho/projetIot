import { Pipe, PipeTransform } from '@angular/core';
import { BookElement } from '../service/book.service';

@Pipe({
  name: 'order',
  pure:false //n9iya  //reason to set false : execute pipe when add new book 
})
export class OrderPipe implements PipeTransform {

  transform(value: BookElement[],orderType:number=1): BookElement[] {
    if(value !=undefined && value.length>1){
      if(orderType==-1){ 
        return value.sort((book2,book1)=>(book1.code>book2.code)?1:-1) //DESC 
      }
      return value.sort((book2,book1)=>(book1.code<book2.code)?1:-1)  //ASC 
    }
    
  }

}

