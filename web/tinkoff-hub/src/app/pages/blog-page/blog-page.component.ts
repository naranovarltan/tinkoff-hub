import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog-page',
  templateUrl: './blog-page.component.html',
  styleUrls: ['./blog-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class BlogPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
