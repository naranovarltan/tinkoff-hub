import { ChangeDetectionStrategy, Component } from '@angular/core';
import { tuiIconPin, tuiIconArrowRight } from '@tinkoff-ui/angular-icons';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PostComponent {
  public tuiIconPin = tuiIconPin;
  public tuiIconArrowRight = tuiIconArrowRight;
}
