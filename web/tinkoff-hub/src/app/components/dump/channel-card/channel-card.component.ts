import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-channel-card',
  templateUrl: './channel-card.component.html',
  styleUrls: ['./channel-card.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ChannelCardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
