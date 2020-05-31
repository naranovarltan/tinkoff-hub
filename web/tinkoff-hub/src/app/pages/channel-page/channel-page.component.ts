import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-channel-page',
  templateUrl: './channel-page.component.html',
  styleUrls: ['./channel-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ChannelPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public navigateToPost(postId: string): void {
    this.router.navigateByUrl(`/feeds/news/${postId}`);
  }

  public navigateToChannelsPage(event: Event): void {
    event.stopPropagation();

    this.router.navigateByUrl('/feeds/channels');
  }
}
