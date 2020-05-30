import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FeedsPageRoutingModule } from './feeds-page-routing.module';
import { FeedsPageComponent } from './feeds-page.component';

@NgModule({
  declarations: [FeedsPageComponent],
  imports: [
    CommonModule,
    FeedsPageRoutingModule
  ]
})
export class FeedsPageModule { }
