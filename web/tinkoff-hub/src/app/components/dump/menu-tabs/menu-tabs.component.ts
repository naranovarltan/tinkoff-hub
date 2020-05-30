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
    },
    {
      name: 'Рабочие новости',
      link: PathConfig.WORKING_NEWS,
    },
    {
      name: 'Мои каналы',
      link: PathConfig.CHANNELS,
    },
    {
      name: 'Мой блог',
      link: PathConfig.BLOG,
    }
  ];
}
