import { Component, Input, OnInit } from '@angular/core';
import { Environment, EnvironmentService } from '../../Service/environment.service';

@Component({
  selector: 'app-item-environment',
  templateUrl: './item-environment.component.html',
  styleUrls: ['./item-environment.component.css'],
})
export class ItemEnvironmentComponent implements OnInit {
  @Input() environment: Environment;
  

  constructor(private environmentService:EnvironmentService) {}

  ngOnInit(): void {
  
  }

  getLastDataNode(id:string){
    console.log(id);

  }


}
