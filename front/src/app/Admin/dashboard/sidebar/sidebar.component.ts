import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Auth/Service/auth.service';

@Component({
  selector: 'admin-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private logService:AuthService) { }

  ngOnInit(): void {
  }
  toggleSideBar(){
    let sidebar=document.querySelector(".admin-sidebar");
    let content=document.querySelector(".content");
    sidebar.classList.toggle('active');
    content.classList.toggle('active');
  }
  logOut(){
    this.logService.logOut();
    
  }

}
