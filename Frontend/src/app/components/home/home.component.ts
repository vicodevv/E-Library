import { HttpClient } from '@angular/common/http';
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
export class HomeComponent implements OnInit{
  books: any;
  
  constructor( private http: HttpClient) { }


  ngOnInit(): void {
    let response = this.http.get<APIResponse<Book>>(`http://localhost:8080/api/books`);
    response.subscribe((data) => this.books = data);
}

}
