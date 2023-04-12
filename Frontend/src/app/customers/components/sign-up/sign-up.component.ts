import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  //public loginError: string;
  
  signupForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    phoneNumber: new FormControl('', [Validators.required, Validators.minLength(10)]),
    address: new FormControl('', [Validators.required]),
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  })

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

  addNewUser() {
    this.httpService.addNewUser({}).subscribe((response: any) => {
      console.log(response);
    });
  }

  onSubmit(){  
    if(this.signupForm.valid){
      this.httpService.signUp(this.signupForm.value)
      .subscribe((data) => {
        if(data.status === 200 && !data.body.ErrorCode){
            this.router.navigate(['/']);
        }else{
            console.log(data.body.ErrorMessage);
        }        
      },
      (error) => {
        console.log(error);
      }
      )
    }    
  }

}
