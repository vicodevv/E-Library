import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { environment as env } from 'src/environments/environment';
import { APIResponse, Book } from '../models';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private readonly BASE_URL = env.BASE_URL; 
  loginStatus = new BehaviorSubject<boolean>(this.hasToken());

  constructor(private http: HttpClient,  private cookieService: CookieService) { }

  // Get all books
  public getAllBooks(){
    return this.http.get<APIResponse<Book>>(`${this.BASE_URL}/api/books`);
  }

  // Login a user
  public SignIn(formData:any):Observable<HttpResponse<any>>{
    return this.http.post<any>(`${this.BASE_URL}/api/login`,formData,  { observe: 'response' })
    .pipe(
      tap((resp: HttpResponse<any>) => {
        if(resp.body.token){
          this.cookieService.set('currentUser', resp.body.token);
          this.loginStatus.next(true);
        }
        return resp;  
      }),
      catchError(this.handleError)
    );
  }
    /**
   * 
   * @param formData as the login form data
   */

  // Sign up a new user
  public signUp(formData:any):Observable<HttpResponse<any>>{
      return this.http.post<any>(`${this.BASE_URL}/api/users`,formData,  { observe: 'response' })
      .pipe(
        tap((resp: HttpResponse<any>) => {
          return resp;  
        }),
        catchError(this.handleError)
      );
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

    // Check if the user has a token
    private hasToken() : boolean {
      return this.cookieService.check('currentUser');
    }
}
