import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-page',
  templateUrl: './post-page.component.html',
  styleUrls: ['./post-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PostPageComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit(): void {
  }

  public navigateToNewsPage(): void {
    this.router.navigateByUrl('/feeds/news');
  }

}
