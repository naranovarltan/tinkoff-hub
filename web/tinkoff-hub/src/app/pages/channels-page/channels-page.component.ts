import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-channels-page',
  templateUrl: './channels-page.component.html',
  styleUrls: ['./channels-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ChannelsPageComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit() {
  }

  public onNavigateToChannel(channelId: string): void {
    this.router.navigateByUrl(`/feeds/channels/${channelId}`);
  }
}
