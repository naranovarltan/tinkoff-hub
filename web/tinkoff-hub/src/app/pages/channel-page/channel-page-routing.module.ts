import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChannelPageComponent } from './channel-page.component';


const routes: Routes = [
  {
    path: '',
    component: ChannelPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChannelPageRoutingModule { }
