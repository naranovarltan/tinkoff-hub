import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
  selector: 'app-feeds-header',
  templateUrl: './feeds-header.component.html',
  styleUrls: ['./feeds-header.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FeedsHeaderComponent {
  public items = ['Мой блог', 'Выбрать канал'];

  public opened = false;

  onClick() {
    this.opened = false;
  }
}
