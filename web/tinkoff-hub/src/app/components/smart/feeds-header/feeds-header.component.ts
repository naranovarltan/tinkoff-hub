import { ChangeDetectionStrategy, Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feeds-header',
  templateUrl: './feeds-header.component.html',
  styleUrls: ['./feeds-header.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FeedsHeaderComponent {
  public items = ['Мой блог'];

  public opened = false;

  constructor(private router: Router) {}

  public onClick() {
    this.opened = false;

    this.router.navigateByUrl('feeds/blog/create-post');
  }
}
