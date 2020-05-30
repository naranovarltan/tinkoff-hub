import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChannelsPageRoutingModule } from './channels-page-routing.module';
import { ChannelsPageComponent } from './channels-page.component';

@NgModule({
  declarations: [ChannelsPageComponent],
  imports: [
    CommonModule,
    ChannelsPageRoutingModule
  ]
})
export class ChannelsPageModule { }
