import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BlogPageComponent } from './blog-page.component';
import { CreatePostComponent } from './views/create-post/create-post.component';
import { BlogPostsComponent } from './views/blog-posts/blog-posts.component';

const routes: Routes = [
  {
    path: '',
    component: BlogPageComponent,
    children: [
      {
        path: '',
        pathMatch: 'full',
        redirectTo: 'create-post',
      },
      {
        path: 'create-post',
        component: CreatePostComponent,
      },
      {
        path: 'blog-posts',
        component: BlogPostsComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogPageRoutingModule { }
