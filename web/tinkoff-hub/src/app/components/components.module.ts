import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TuiSvgModule, TuiButtonsModule, TuiModeModule } from '@tinkoff-ui/angular-core';
import { TuiTabsModule } from '@tinkoff-ui/angular-kit';
import { FeedsHeaderComponent } from './smart/feeds-header/feeds-header.component';
import { MenuTabsComponent } from './dump/menu-tabs/menu-tabs.component';
import { RouterModule } from '@angular/router';
import { PostComponent } from './dump/post/post.component';
import { ChannelComponent } from './dump/channel/channel.component';

const COMPONENTS = [
  FeedsHeaderComponent,
  MenuTabsComponent,
  PostComponent,
  ChannelComponent,
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
