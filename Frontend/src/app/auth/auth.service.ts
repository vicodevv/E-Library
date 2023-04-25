import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse, HttpParams, HttpHeaders } from '@angular/common/http';
import { environment as env } from 'src/environments/environment';
import { APIResponse, Book } from '../models';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import * as moment from "moment";

const AUTH_API = 'http://localhost:8080/api/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private readonly BASE_URL = env.BASE_URL; 

  constructor(private http: HttpClient) { }

  // Get all books
  public getAllBooks(){
    return this.http.get<APIResponse<Book>>( this.BASE_URL + '/api/books', httpOptions);
  }

  // Add a book
  addBook(title: string, author: string, publishedDate: string, category: string, packageType: string, availableQuantity: number, totalQuantity: number, coverPage: string){
    return this.http.post(AUTH_API + 'books', {
      title,
      author,
      publishedDate,
      category,
      packageType,
      availableQuantity,
      totalQuantity,
      coverPage
      }, httpOptions);
  }

  //Delete a book
  deletebook(bookId: number){
    return this.http.delete<APIResponse<Book>>(this.BASE_URL + `/api/books/${bookId}`, httpOptions)
  }

  // Borrow a book
  borrowBook(bookId: number){
    return this.http.post<APIResponse<Book>>(this.BASE_URL + `/api/books/borrow/${bookId}`, httpOptions)
    }
  // Login a user
  login(userName: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'login', {
      userName,
      password
    }, httpOptions);
  }

  // Register a user
  register(email: string,firstName: string, lastName: string, phoneNumber: number, address: string, userName: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'users', {
      email,
      firstName,
      lastName,
      phoneNumber,
      address,
      userName,
      password
    }, httpOptions);
  }


   // Handle Http operation that failed.
   private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
  
}
