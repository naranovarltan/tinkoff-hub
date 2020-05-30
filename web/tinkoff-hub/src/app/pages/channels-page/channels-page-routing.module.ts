import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChannelsPageComponent } from './channels-page.component';

const routes: Routes = [
  {
    path: '',
    component: ChannelsPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChannelsPageRoutingModule { }
