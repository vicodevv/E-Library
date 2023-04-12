import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/auth/api.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  public signUpError!: string;
  
  signUpForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    phoneNumber: new FormControl('', [Validators.required, Validators.minLength(10)]),
    address: new FormControl('', [Validators.required]),
    userName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })
  hide = true;
  
  constructor(
    private router: Router,
    private httpService: HttpService,) {}

  ngOnInit() {
  }

  homePage(): void {
    this.router.navigateByUrl('');
  }

  signInPage(): void {
    this.router.navigateByUrl('sign-in');
  }

  onSubmit(){  
    if(this.signUpForm.valid){
      this.httpService.signUp(this.signUpForm.value)
      .subscribe((data) => {
        if(data.status === 200 && !data.body.ErrorCode){
            this.router.navigate(['']);
        }else{
          this.signUpError = data.body.message;
        }        
      },
      error => this.signUpError = error
      )
    }    
  }

}
