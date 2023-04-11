import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {

  constructor(private router: Router) {}
  
  homePage(): void {
    this.router.navigateByUrl('admin');
  }
  
  signInPage(): void {
    this.router.navigateByUrl('admin/sign-in');
  }
}
