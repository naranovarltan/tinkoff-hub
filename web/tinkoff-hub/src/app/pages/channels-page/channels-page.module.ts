import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChannelsPageRoutingModule } from './channels-page-routing.module';
import { ChannelsPageComponent } from './channels-page.component';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [ChannelsPageComponent],
  imports: [
    CommonModule,
    ChannelsPageRoutingModule,
    ComponentsModule,
  ]
})
export class ChannelsPageModule {}
