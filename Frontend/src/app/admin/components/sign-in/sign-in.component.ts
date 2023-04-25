import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/auth/auth.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit  {

  loginForm: any = new FormGroup({
    userName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  isLoggedIn = false;
  isLoginFailed = false;


  errorMessage = 'Incorrect Username or Password';
  roles: string[] = [];
  hide = true;

  public loginError!: string;

  constructor(
    private router: Router,
    private httpService: HttpService,
    private tokenStorage: TokenStorageService
    ) {}

    ngOnInit() {
      if (this.tokenStorage.getToken()) {
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
      }
    }

    onSubmit(): void {
      const { userName, password } = this.loginForm;
  
      this.httpService.login(userName, password).subscribe(
        data => {
          this.tokenStorage.saveToken(data.access_token);
          this.tokenStorage.saveUser(data);
          console.log(data);
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.router.navigateByUrl('/admin');
        },
        err => {
          this.isLoginFailed = true;
          if (this.isLoginFailed = true) {
            this.loginError = 'Incorrect Username or Password';
          }
        }
      );
    }

  homePage(): void {
    this.router.navigateByUrl('admin');
  }

  signUpPage(): void {
    this.router.navigateByUrl('admin/sign-up');
  }

}
