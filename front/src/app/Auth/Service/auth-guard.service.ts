import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate ,CanActivateChild{

  constructor(private authService:AuthService,private router:Router) { }
  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean |  Promise<boolean>{
    
    
    if(!this.authService.isAuthenticated()){
      return this.router.navigateByUrl("/login");
    }
    return this.authService.isAuthenticated();
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Promise<boolean> {
    
    if(!this.authService.isAuthenticated()){
      return this.router.navigateByUrl("/login");
    }
    return this.authService.isAuthenticated();
  }
}
