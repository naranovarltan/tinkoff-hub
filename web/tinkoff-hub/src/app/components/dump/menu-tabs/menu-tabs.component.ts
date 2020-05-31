import { ChangeDetectionStrategy, Component } from '@angular/core';
import { PathConfig } from '../../../configs/path.config';
import { MenuTabInterface } from '../../../interfaces/menu-tab.interface';

@Component({
  selector: 'app-menu-tabs',
  templateUrl: './menu-tabs.component.html',
  styleUrls: ['./menu-tabs.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class MenuTabsComponent {

  public menuTabs: MenuTabInterface[] = [
    {
      name: 'Новости',
      link: PathConfig.NEWS,
      count: 2,
    },
    {
      name: 'Рабочие новости',
      link: PathConfig.WORKING_NEWS,
      count: 0,
    },
    {
      name: 'Мои каналы',
      link: PathConfig.CHANNELS,
      count: 0,
    },
    {
      name: 'Мой блог',
      link: PathConfig.BLOG,
      count: 0,
    }
  ];
}
