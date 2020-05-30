import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feeds-page',
  templateUrl: './feeds-page.component.html',
  styleUrls: ['./feeds-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FeedsPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
