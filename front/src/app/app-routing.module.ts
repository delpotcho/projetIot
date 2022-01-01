import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductComponent } from './Admin/product/product.component';
import { FormProductComponent } from './Admin/product/form-product/form-product.component';
import { ItemProductComponent } from './Admin/product/list-product/item-product/item-product.component';
import { ListBookComponent } from './Admin/product/list-product/list-product.component';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { HomeComponent } from './Admin/home/home.component';
import { LoginComponent } from './Auth/login/login.component';
import { SignUpComponent } from './Auth/sign-up/sign-up.component';
import { AuthGuardService } from './Auth/Service/auth-guard.service';
import { EnvironmentComponent } from './Admin/Environment/environment/environment.component';
import { componentFactoryName } from '@angular/compiler';
import { environment } from 'src/environments/environment';
import { ListEnvironmentComponent } from './Admin/Environment/list-environment/list-environment.component';
import { EnvironmentDetailComponent } from './Admin/Environment/environment-detail/environment-detail.component';
import { EnvironmentFormComponent } from './Admin/Environment/environment-form/environment-form.component';

const routes: Routes = [
  { path: 'admin', redirectTo: '/admin/dashboard', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'register', component: SignUpComponent, pathMatch: 'full' },

  {
    path: 'admin',
    component: DashboardComponent,
    // canActivate:[AuthGuardService],

    children: [
      {
        path: 'dashboard',
        component: HomeComponent,
        pathMatch: 'full',
      },
      {
        path: 'product',
        component: ProductComponent,
        children: [
          {
            path: '',
            component: ListBookComponent,
            children: [
              {
                path: 'new',
                component: FormProductComponent,
                pathMatch: 'full',
              },
              {
                path: 'edit/:id',
                component: FormProductComponent,
                pathMatch: 'full',
              },
            ],
          },

          {
            path: ':id',
            component: ItemProductComponent,
            pathMatch: 'full',
          },
        ],
      },
      {
        path: 'environment',
        component: EnvironmentComponent,
        children: [
          {
            path: '',
            component: ListEnvironmentComponent,
            children: [
              {
                path: 'new',
                component: EnvironmentFormComponent,
                pathMatch: 'full',
              },
            ],
          },
          {
            path: ':id',
            component: EnvironmentDetailComponent,
          },
        ],
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
