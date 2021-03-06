import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { WorkingNewsPageRoutingModule } from './working-news-page-routing.module';
import { WorkingNewsPageComponent } from './working-news-page.component';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [WorkingNewsPageComponent],
  imports: [
    CommonModule,
    RouterModule,
    WorkingNewsPageRoutingModule,
    ComponentsModule,
  ]
})
export class WorkingNewsPageModule { }
