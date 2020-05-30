import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PathConfig } from '../../configs/path.config';
import { LoginPageComponent } from './login-page.component';

const routes: Routes = [
  {
    path: PathConfig.DEFAULT,
    component: LoginPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginPageRoutingModule { }
