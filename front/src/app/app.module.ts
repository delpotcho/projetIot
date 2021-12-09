import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { SidebarComponent } from './Admin/dashboard/sidebar/sidebar.component';
import { HomeComponent } from './Admin/home/home.component';
import { BookComponent } from './Admin/product/product.component';
import { FormBookComponent } from './Admin/product/form-product/form-product.component';
import { ListBookComponent } from './Admin/product/list-product/list-product.component';
import { ItemBookComponent } from './Admin/product/list-product/item-product/item-product.component';
import { LoginComponent } from './Auth/login/login.component';
import { SignUpComponent } from './Auth/sign-up/sign-up.component';
import { AuthorComponent } from './Admin/author/author.component';
import { ListAuthorComponent } from './Admin/author/list-author/list-author.component';
import { FormAuthorComponent } from './Admin/author/form-author/form-author.component';
import { CardAuthorComponent } from './Admin/author/card-author/card-author.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SidebarComponent,
    HomeComponent,
    BookComponent,
    FormBookComponent,
    ListBookComponent,
    ItemBookComponent, 
    LoginComponent,
    SignUpComponent,
    AuthorComponent,
    ListAuthorComponent,
    FormAuthorComponent,
    CardAuthorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
