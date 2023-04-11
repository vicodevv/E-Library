import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  
  constructor(
    private router: Router,
    private httpService: HttpService,) {}

  homePage(): void {
    this.router.navigateByUrl('');
  }

  signInPage(): void {
    this.router.navigateByUrl('sign-in');
  }

  addNewUser() {
    this.httpService.addNewUser({}).subscribe((response: any) => {
      console.log(response);
    });
  }


}
