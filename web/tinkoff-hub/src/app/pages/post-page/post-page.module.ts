import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PolymorpheusModule } from '@tinkoff/ng-polymorpheus';
import { TuiHostedDropdownModule, TuiMenuItemsModule } from '@tinkoff-ui/angular-core';

import { PostPageRoutingModule } from './post-page-routing.module';
import { PostPageComponent } from './post-page.component';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [PostPageComponent],
  imports: [
    CommonModule,
    PostPageRoutingModule,
    RouterModule,
    ComponentsModule,
    PolymorpheusModule,
    TuiHostedDropdownModule,
    TuiMenuItemsModule,
  ]
})
export class PostPageModule {
}
