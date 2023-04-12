import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  loginForm = new FormGroup({
    userName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  })

  public loginError!: string;
  
  constructor(
    private router: Router,
    private httpService: HttpService) {}

  ngOnInit() {
  }

  onSubmit(){  
    if(this.loginForm.valid){
      this.httpService.SignIn(this.loginForm.value)
      .subscribe((data) => { console.log(data);
        if(data.status === 200 && !data.body.ErrorCode){
            this.router.navigate(['']);
        }else{
          this.loginError = data.body.message;
        }        
      },
      error => this.loginError = error
      )
    }    
  }

  homePage(): void {
    this.router.navigateByUrl('');
  }
  signUpPage(): void {
    this.router.navigateByUrl('sign-up');
  }

}
