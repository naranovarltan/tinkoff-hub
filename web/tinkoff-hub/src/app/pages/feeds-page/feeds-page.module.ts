import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeedsPageRoutingModule } from './feeds-page-routing.module';
import { FeedsPageComponent } from './feeds-page.component';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [FeedsPageComponent],
  imports: [
    CommonModule,
    FeedsPageRoutingModule,
    ComponentsModule,
  ]
})
export class FeedsPageModule { }
