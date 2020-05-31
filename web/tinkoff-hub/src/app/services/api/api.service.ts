import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private api = 'asd.ru';

  constructor() { }

  private get MAIN(): string {
    return this.api;
  }

  public get NEWS(): string {
    return `${this.MAIN}`;
  }

  public get NEWS1(): string {
    return `${this.MAIN}`;
  }

  public get NEWS2(): string {
    return `${this.MAIN}`;
  }

  public get NEWS3(): string {
    return `${this.MAIN}`;
  }
}
