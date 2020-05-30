import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewsPageRoutingModule } from './news-page-routing.module';
import { NewsPageComponent } from './news-page.component';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [NewsPageComponent],
  imports: [
    CommonModule,
    NewsPageRoutingModule,
    ComponentsModule,
  ],
})
export class NewsPageModule {}
