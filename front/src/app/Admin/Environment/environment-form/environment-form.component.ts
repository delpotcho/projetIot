import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import {
  Environment,
  EnvironmentService,
} from '../Service/environment.service';

@Component({
  selector: 'app-environment-form',
  templateUrl: './environment-form.component.html',
  styleUrls: ['./environment-form.component.css'],
})
export class EnvironmentFormComponent implements OnInit {
  environmentForm: FormGroup;
  idEnvironment: number;
  constructor(
    private router: Router,
    private environmentService: EnvironmentService
  ) {}

  ngOnInit(): void {
    this.environmentForm = new FormGroup({
      name: new FormControl(null),
      minTemperature: new FormControl(null),
      maxTemperature: new FormControl(null),
      minHumidity: new FormControl(null),
      maxHumidity: new FormControl(null),
      nodes: new FormControl(null),
    });
  }

  onSubmit() {
    let environment: Environment = this.environmentForm.value;
    this.environmentService.newEnvironment(environment).subscribe(
      (data) => console.log(data),
      (err) => console.log(err)
    );
  }
  returnToListEnvironment() {
    this.router.navigateByUrl('/admin/environment');
  }
}
