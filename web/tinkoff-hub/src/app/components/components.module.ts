import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TuiSvgModule, TuiButtonsModule, TuiModeModule } from '@tinkoff-ui/angular-core';
import { TuiTabsModule } from '@tinkoff-ui/angular-kit';
import { FeedsHeaderComponent } from './smart/feeds-header/feeds-header.component';
import { MenuTabsComponent } from './dump/menu-tabs/menu-tabs.component';
import { RouterModule } from '@angular/router';
import { PostComponent } from './dump/post/post.component';

const COMPONENTS = [
  FeedsHeaderComponent,
  MenuTabsComponent,
  PostComponent
];

const TUI_MODULES = [
  TuiSvgModule,
  TuiButtonsModule,
  TuiTabsModule,
  TuiModeModule,
];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [CommonModule, RouterModule, TUI_MODULES],
  exports: [...COMPONENTS]
})
export class ComponentsModule {}
