import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { BlogPageRoutingModule } from './blog-page-routing.module';
import { BlogPageComponent } from './blog-page.component';
import { CreatePostComponent } from './views/create-post/create-post.component';
import { BlogPostsComponent } from './views/blog-posts/blog-posts.component';
import { ComponentsModule } from '../../components/components.module';

@NgModule({
  declarations: [BlogPageComponent, CreatePostComponent, BlogPostsComponent],
  imports: [
    CommonModule,
    BlogPageRoutingModule,
    RouterModule,
    ComponentsModule,
  ]
})
export class BlogPageModule { }
