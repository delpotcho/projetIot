import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService, LoginInfo } from '../Service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService:AuthService,private route:Router) {
    if(localStorage.getItem("user")!=null && localStorage.getItem("user")=="conected"){
      this.route.navigateByUrl("/environment");

    }
   }

  ngOnInit(): void {
  }

  login(form:NgForm){
    let info= new LoginInfo(form.value.username,form.value.password)
    console.log(form.value);
    this.authService.login(info).subscribe(data=>{
      localStorage.setItem("user","conected");
      this.route.navigateByUrl("/environment");
    },err=>console.log(err));
  }

}
