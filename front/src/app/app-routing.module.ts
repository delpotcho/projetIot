import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookComponent } from './Admin/product/product.component';
import { FormBookComponent } from './Admin/product/form-product/form-product.component';
import { ItemBookComponent } from './Admin/product/list-product/item-product/item-product.component';
import { ListBookComponent } from './Admin/product/list-product/list-product.component';
import { DashboardComponent } from './Admin/dashboard/dashboard.component';
import { HomeComponent } from './Admin/home/home.component';
import { LoginComponent } from './Auth/login/login.component';
import { SignUpComponent } from './Auth/sign-up/sign-up.component';

const routes: Routes = [
  { path: 'admin', redirectTo: '/admin/dashboard', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'signup', component: SignUpComponent, pathMatch: 'full' },

  {
    path: 'admin',
    component: DashboardComponent,
    children: [
      {
        path: 'dashboard',
        component: HomeComponent,
        pathMatch: 'full',
      },
      {
        path: 'product',
        component: BookComponent,
        children: [
          {
            path: '',
            component: ListBookComponent,
            children: [
              {
                path: 'new',
                component: FormBookComponent,
                pathMatch: 'full',
              },
              {
                path: 'edit/:id',
                component: FormBookComponent,
                pathMatch: 'full',
              },
            ],
          },

          {
            path: ':id',
            component: ItemBookComponent,
            pathMatch: 'full',
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
