import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-channels-page',
  templateUrl: './channels-page.component.html',
  styleUrls: ['./channels-page.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ChannelsPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
