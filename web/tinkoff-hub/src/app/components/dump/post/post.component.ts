import { ChangeDetectionStrategy, Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.less'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PostComponent {
  @Output() navigateToPost = new EventEmitter<string>();

  public onNavigateToPost(event: Event): void {
    event.stopPropagation();

    this.navigateToPost.emit('123');
  }
}
