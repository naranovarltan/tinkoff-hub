import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WorkingNewsPageRoutingModule } from './working-news-page-routing.module';
import { WorkingNewsPageComponent } from './working-news-page.component';

@NgModule({
  declarations: [WorkingNewsPageComponent],
  imports: [
    CommonModule,
    WorkingNewsPageRoutingModule
  ]
})
export class WorkingNewsPageModule { }
