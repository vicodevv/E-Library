import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { APIResponse, Book } from 'src/app/models';
import { HttpService } from 'src/app/service/http.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  public sort: string = 'relevance';
  public book!: Array<Book>;
  private routeSubscribtion!: Subscription;
  private bookSubscribtion!: Subscription;

  constructor(
    private httpService: HttpService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.routeSubscribtion = this.activatedRoute.queryParams.subscribe((params: Params) => {
      if (params['book-search']) {
        this.searchBooks('metacrit',params['book-search']);
      }
      else{
        this.searchBooks('metacrit');
      }
    });
  }

  searchBooks(sort: string, search?: string): void {
    this.bookSubscribtion = this.httpService
      .getBooksList(sort, search)
      .subscribe((bookList: APIResponse<Book>) => {
        this.book = bookList.results;
        console.log(bookList);
      });
  }

  ngOnDestroy(): void {
    if (this.routeSubscribtion) {
      this.routeSubscribtion.unsubscribe();
    }
    if (this.bookSubscribtion) {
      this.bookSubscribtion.unsubscribe();
    }
  }
}

