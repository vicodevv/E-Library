import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  constructor(private router: Router) {}

  booksPage(): void {
    this.router.navigateByUrl('admin/books');
  }

  homepage(): void {
    this.router.navigateByUrl('admin');
  }

}
