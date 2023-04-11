import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { AdminRoutingModule } from './admin-routing.module';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { AdminComponent } from './admin.component';
import { BooksComponent } from './components/books/books.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AdminComponent,
    SignInComponent,
    SignUpComponent,
    HeaderComponent,
    HomeComponent,
    BooksComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    CommonModule,
    AdminRoutingModule
  ],
  bootstrap: [AdminComponent]
})
export class AdminModule { }
