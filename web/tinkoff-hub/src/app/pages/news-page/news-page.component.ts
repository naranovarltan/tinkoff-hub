import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-news-page',
  templateUrl: './news-page.component.html',
  styleUrls: ['./news-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NewsPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public navigateToPost(postId: string): void {
    this.router.navigateByUrl(`/feeds/news/${postId}`);
  }
}
