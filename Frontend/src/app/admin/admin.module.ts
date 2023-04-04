import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';



@NgModule({
  declarations: [
    SignInComponent,
    SignUpComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AdminModule { }
