import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CustomerRoutingModule } from './customer-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { GaugeModule } from 'angular-gauge';
import { MatTabsModule } from "@angular/material/tabs";
import { MatIconModule } from "@angular/material/icon";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from "@angular/material/select";
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { HttpService } from '../auth/auth.service';
import { BooksComponent } from './components/books/books.component';
import { ModalComponent } from './components/modal/modal.component';
import { MdbModalService } from 'mdb-angular-ui-kit/modal';
import { CustomerComponent } from './customer.component';
import { CookieService } from 'ngx-cookie-service';
import { CustomerInterceptor } from '../auth/customer.interceptor';

@NgModule({
  declarations: [
    CustomerComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    SignInComponent,
    SignUpComponent,
    BooksComponent,
    ModalComponent,
  ],
  imports: [
    BrowserModule,
    CustomerRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    GaugeModule.forRoot(),
    MatTabsModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    HttpService,
    MdbModalService,
    CookieService, {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomerInterceptor,
      multi: true
  },
  ],
  bootstrap: [CustomerComponent]
})
export class CustomerModule { }
