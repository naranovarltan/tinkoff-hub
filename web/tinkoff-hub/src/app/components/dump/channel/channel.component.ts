import { ChangeDetectionStrategy, Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-channel',
  templateUrl: './channel.component.html',
  styleUrls: ['./channel.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ChannelComponent {
  @Output() navigateToChannel = new EventEmitter<string>();

  public onNavigateToChannel(event: Event): void {
    event.stopPropagation();

    this.navigateToChannel.emit('123');
  }
}
