import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  public signUpError!: string;
  
  signUpForm: any = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    phoneNumber: new FormControl('', [Validators.required, Validators.minLength(10)]),
    address: new FormControl('', [Validators.required]),
    userName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  hide = true;
  
  constructor(
    private router: Router,
    private httpService: HttpService,) {}

  ngOnInit() {
  }

  onSubmit(){  
    const { email, firstName, lastName, phoneNumber, address, userName, password } = this.signUpForm;

    this.httpService.register(email, firstName, lastName, phoneNumber, address, userName, password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigateByUrl('sign-in');
      },
       err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
   
  }
  homePage(): void {
    this.router.navigateByUrl('');
  }

  signInPage(): void {
    this.router.navigateByUrl('sign-in');
  }

  

}
