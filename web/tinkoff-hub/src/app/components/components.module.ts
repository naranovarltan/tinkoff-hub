import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeedsHeaderComponent } from './smart/feeds-header/feeds-header.component';
import { MenuTabsComponent } from './dump/menu-tabs/menu-tabs.component';
import { RouterModule } from '@angular/router';
import { PostComponent } from './dump/post/post.component';

const COMPONENTS = [
  FeedsHeaderComponent,
  MenuTabsComponent,
];

@NgModule({
  declarations: [...COMPONENTS, PostComponent],
  imports: [CommonModule, RouterModule],
  exports: [...COMPONENTS]
})
export class ComponentsModule {}
