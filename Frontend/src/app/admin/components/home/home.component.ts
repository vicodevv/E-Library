import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models';
import { HttpService } from 'src/app/auth/auth.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public bookId!: number;
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
  deleteBook(bookId: number) {
    this.httpService.deletebook(bookId).subscribe((response: any) => {
      console.log(response);
      this.getBooks();
    });
  }
}
