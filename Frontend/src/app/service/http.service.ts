import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { environment as env } from 'src/environments/environment';
import { APIResponse, Book } from '../models';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private readonly BASE_URL = env.BASE_URL; 

  constructor(private http: HttpClient) { }

  public getAllBooks(){
    return this.http.get<APIResponse<Book>>(`${this.BASE_URL}/api/books`);
  }
  public addNewUser(user: any){
    return this.http.post(`${this.BASE_URL}/api/users`, user);
  }
    /**
   * 
   * @param formData as the login form data
   */
  public signUp(formData:any):Observable<HttpResponse<any>>{
      return this.http.post<any>(this.BASE_URL+"api/users",formData,  { observe: 'response' })
      .pipe(
        tap((resp: HttpResponse<any>) => {
          return resp;  
        }),
        catchError(this.handleError)
      );
    }
    
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
