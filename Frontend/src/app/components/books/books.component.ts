import { Component, OnInit } from '@angular/core';
import { APIResponse, Book } from 'src/app/models';
import { HttpService } from 'src/app/service/http.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {
  public books: Array<Book> = [];

  constructor(
    private httpService: HttpService,
  ) { }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks() {
    this.httpService.getAllBooks().subscribe((response: any) => {
      this.books = response;
      console.log(response);
    });
  }

}
