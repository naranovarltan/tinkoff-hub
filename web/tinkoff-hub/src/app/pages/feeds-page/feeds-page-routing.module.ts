import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PathConfig } from '../../configs/path.config';
import { FeedsPageComponent } from './feeds-page.component';

const routes: Routes = [
  {
    path: PathConfig.DEFAULT,
    component: FeedsPageComponent,
    children: [
      {
        path: '',
        redirectTo: PathConfig.NEWS,
        pathMatch: 'full',
      },
      {
        path: PathConfig.NEWS,
        loadChildren: () => import('../news-page/news-page.module').then(m => m.NewsPageModule),
      },
      {
        path: `${PathConfig.NEWS}/:id`,
        loadChildren: () => import('../post-page/post-page.module').then(m => m.PostPageModule),
      },
      {
        path: PathConfig.WORKING_NEWS,
        loadChildren: () => import('../working-news-page/working-news-page.module').then(m => m.WorkingNewsPageModule),
      },
      {
        path: `${PathConfig.WORKING_NEWS}/:id`,
        loadChildren: () => import('../post-page/post-page.module').then(m => m.PostPageModule),
      },
      {
        path: PathConfig.CHANNELS,
        loadChildren: () => import('../channels-page/channels-page.module').then(m => m.ChannelsPageModule),
      },
      {
        path: `${PathConfig.CHANNELS}/:id`,
        loadChildren: () => import('../channel-page/channel-page.module').then(m => m.ChannelPageModule),
      },
      {
        path: PathConfig.BLOG,
        loadChildren: () => import('../blog-page/blog-page.module').then(m => m.BlogPageModule),
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeedsPageRoutingModule { }
