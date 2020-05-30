import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PathConfig } from './configs/path.config';

const routes: Routes = [
  {
    path: PathConfig.LOGIN,
    loadChildren: () => import('./pages/login-page/login-page.module').then(m => m.LoginPageModule),
  },
  {
    path: PathConfig.FEEDS,
    loadChildren: () => import('./pages/feeds-page/feeds-page.module').then(m => m.FeedsPageModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
