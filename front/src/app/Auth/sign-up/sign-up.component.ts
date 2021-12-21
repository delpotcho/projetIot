import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService, RegisterInfo } from '../Service/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }
  register(form:NgForm){
    let  info=new RegisterInfo(form.value.username,form.value.password);
    this.authService.register(info).subscribe(data=>console.log(data),err=>console.log(err));
    
  }

}
