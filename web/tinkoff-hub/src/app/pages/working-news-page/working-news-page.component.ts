import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-working-news-page',
  templateUrl: './working-news-page.component.html',
  styleUrls: ['./working-news-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class WorkingNewsPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
