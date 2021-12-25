import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { SidebarComponent } from './Admin/dashboard/sidebar/sidebar.component';
import { HomeComponent } from './Admin/home/home.component';
import { ProductComponent } from './Admin/product/product.component';
import { FormProductComponent } from './Admin/product/form-product/form-product.component';
import { ListBookComponent } from './Admin/product/list-product/list-product.component';
import { ItemBookComponent } from './Admin/product/list-product/item-product/item-product.component';
import { LoginComponent } from './Auth/login/login.component';
import { SignUpComponent } from './Auth/sign-up/sign-up.component';
import { AuthorComponent } from './Admin/author/author.component';
import { ListAuthorComponent } from './Admin/author/list-author/list-author.component';
import { FormAuthorComponent } from './Admin/author/form-author/form-author.component';
import { CardAuthorComponent } from './Admin/author/card-author/card-author.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthGuardService } from './Auth/Service/auth-guard.service';
import { ErrorInterceptor } from './Auth/Service/error-interceptor.service';
import { EnvironmentComponent } from './Admin/Environment/environment/environment.component';
import { ListEnvironmentComponent } from './Admin/Environment/list-environment/list-environment.component';
import { ItemEnvironmentComponent } from './Admin/Environment/list-environment/item-environment/item-environment.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    SidebarComponent,
    HomeComponent,
    ProductComponent,
    FormProductComponent,
    ListBookComponent,
    ItemBookComponent, 
    LoginComponent,
    SignUpComponent,
    AuthorComponent,
    ListAuthorComponent,
    FormAuthorComponent,
    CardAuthorComponent,
    EnvironmentComponent,
    ListEnvironmentComponent,
    ItemEnvironmentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide:HTTP_INTERCEPTORS,useClass:ErrorInterceptor,multi:true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
