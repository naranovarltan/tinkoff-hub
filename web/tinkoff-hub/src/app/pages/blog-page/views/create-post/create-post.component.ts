import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.less']
})
export class CreatePostComponent implements OnInit {

  public form: FormGroup;
  private content: string;

  constructor() { }

  ngOnInit(): void {
    const form = {
      header: new FormControl('', Validators.required),
      shortDescription: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    };

    this.form = new FormGroup(form);
  }

  public setValue(data: string): void {
    this.content = data;
  }

  public onSubmit(): void {
    console.log(this.form.value);
  }
}
