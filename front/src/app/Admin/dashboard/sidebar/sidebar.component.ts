import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'admin-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  toggleSideBar(){
    let sidebar=document.querySelector(".admin-sidebar");
    let content=document.querySelector(".content");
    sidebar.classList.toggle('active');
    content.classList.toggle('active');
  }

}
