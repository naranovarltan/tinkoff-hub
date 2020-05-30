import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feeds-header',
  templateUrl: './feeds-header.component.html',
  styleUrls: ['./feeds-header.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class FeedsHeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
