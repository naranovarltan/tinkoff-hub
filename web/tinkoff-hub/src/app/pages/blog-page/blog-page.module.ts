import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CKEditorModule } from 'ckeditor4-angular';
import { TuiInputModule, TuiBadgeModule } from '@tinkoff-ui/angular-kit';
import { TuiButtonsModule } from '@tinkoff-ui/angular-core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
    CKEditorModule,
    TuiInputModule,
    FormsModule,
    ReactiveFormsModule,
    TuiButtonsModule,
    TuiBadgeModule,
  ]
})
export class BlogPageModule { }
