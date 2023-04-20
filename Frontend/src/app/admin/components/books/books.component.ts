import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit{

  booksForm: any = new FormGroup({
    title: new FormControl('', [Validators.required]),
    author: new FormControl('', [Validators.required]),
    publishedDate: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required]),
    packageType: new FormControl('', [Validators.required]),
    availableQuantity: new FormControl('', [Validators.required]),
    totalQuantity: new FormControl('', [Validators.required]),
    coverPage: new FormControl('', [Validators.required]),
  });
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  hide = true;

  constructor(
    private httpService : HttpService,
    private router: Router,
  ) { }

  ngOnInit() {
  }

  onSubmit(): void {
    const { title, author, publishedDate, category, packageType, availableQuantity, totalQuantity, coverPage } = this.booksForm;

    this.httpService.addBook(title, author, publishedDate, category, packageType, availableQuantity, totalQuantity, coverPage).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigateByUrl('admin');
      }
    );
  }
}
