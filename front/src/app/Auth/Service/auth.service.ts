import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
export class LoginInfo{
  private username:string;
  private password:string;
  public constructor(username:string,password:string){
    this.username=username;
    this.password=password;
  }
}
export class RegisterInfo{
  private username:string;
  private password:string;
  public constructor(username:string,password:string){
    this.username=username;
    this.password=password;
  }
  }
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private authenticated:boolean=false;
  private url:string="http://localhost:8080";
  constructor(private http:HttpClient) { 
  }

  public login(loginInfo:LoginInfo):Observable<LoginInfo>{
    return this.http.post<LoginInfo>(this.url + "/login", loginInfo,{withCredentials:true});
  }
  public register(RegisterInfo:RegisterInfo):Observable<RegisterInfo>{
    return  this.http.post<RegisterInfo>(this.url+"/register",RegisterInfo,{withCredentials:true});
  }

  public isAuthenticated(){
    if(localStorage.getItem("user")!=null){
     return true;
   }
    return false;
  }

  public getAuthenticated(){
   
  }
  public logOut(){
    localStorage.removeItem("user");
  }
}
