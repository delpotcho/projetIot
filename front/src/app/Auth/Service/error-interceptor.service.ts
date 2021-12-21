import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  

  constructor(private authService:AuthService,private router:Router) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    return next.handle(req).
              pipe(catchError(err => { 
      if (err.status === 401) {      
          this.authService.logOut();
          this.router.navigateByUrl("/login");
         
        } 
          const error = err.error.message || err.statusText; 
          return throwError(error); 
    }))
  }
}
