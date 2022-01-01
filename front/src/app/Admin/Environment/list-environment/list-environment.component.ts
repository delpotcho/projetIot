import { Component, OnInit } from '@angular/core';
import {
  Environment,
  EnvironmentService,
} from '../Service/environment.service';

@Component({
  selector: 'app-list-environment',
  templateUrl: './list-environment.component.html',
  styleUrls: ['./list-environment.component.css'],
})
export class ListEnvironmentComponent implements OnInit {
  environments: Environment[];
  constructor(private environmentService: EnvironmentService) {
    this.environments = [];
  }

  ngOnInit(): void {
    this.environmentService.getEnvironments().subscribe(
      (data) => (this.environments = data),
      (err) => console.log(err)
    );
    console.log(this.environments);
  }
}
