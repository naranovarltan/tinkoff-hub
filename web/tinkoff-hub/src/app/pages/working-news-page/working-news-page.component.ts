import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-working-news-page',
  templateUrl: './working-news-page.component.html',
  styleUrls: ['./working-news-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class WorkingNewsPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public navigateToPost(postId: string): void {
    this.router.navigateByUrl(`/feeds/working-news/${postId}`);
  }
}
