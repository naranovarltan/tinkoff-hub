import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChannelPageRoutingModule } from './channel-page-routing.module';
import { ChannelPageComponent } from './channel-page.component';
import { ComponentsModule } from '../../components/components.module';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [ChannelPageComponent],
  imports: [
    CommonModule,
    ChannelPageRoutingModule,
    ComponentsModule,
    RouterModule,
  ]
})
export class ChannelPageModule { }
