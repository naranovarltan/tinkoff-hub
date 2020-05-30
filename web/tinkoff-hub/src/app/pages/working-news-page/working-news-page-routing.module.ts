import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WorkingNewsPageComponent } from './working-news-page.component';

const routes: Routes = [
  {
    path: '',
    component: WorkingNewsPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WorkingNewsPageRoutingModule { }
