import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TuiSvgModule, TuiButtonsModule, TuiModeModule, TuiHostedDropdownModule, TuiMenuItemsModule } from '@tinkoff-ui/angular-core';
import { TuiTabsModule, TuiBadgeModule } from '@tinkoff-ui/angular-kit';
import { PolymorpheusModule } from '@tinkoff/ng-polymorpheus';

import { FeedsHeaderComponent } from './smart/feeds-header/feeds-header.component';
import { MenuTabsComponent } from './dump/menu-tabs/menu-tabs.component';
import { PostComponent } from './dump/post/post.component';
import { ChannelComponent } from './dump/channel/channel.component';
import { PostCardComponent } from './dump/post-card/post-card.component';
import { ChannelCardComponent } from './dump/channel-card/channel-card.component';

const COMPONENTS = [
  FeedsHeaderComponent,
  MenuTabsComponent,
  PostComponent,
  ChannelComponent,
  PostCardComponent,
  ChannelCardComponent,
];

const TUI_MODULES = [
  TuiSvgModule,
  TuiButtonsModule,
  TuiTabsModule,
  TuiModeModule,
  TuiBadgeModule,
  PolymorpheusModule,
  TuiHostedDropdownModule,
  TuiMenuItemsModule,
];

@NgModule({
  declarations: [...COMPONENTS],
  imports: [CommonModule, RouterModule, TUI_MODULES],
  exports: [...COMPONENTS]
})
export class ComponentsModule {}
