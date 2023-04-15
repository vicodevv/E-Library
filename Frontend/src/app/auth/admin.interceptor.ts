import { HTTP_INTERCEPTORS, HttpEvent, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';

import { TokenStorageService } from '../service/token-storage.service';
import { catchError, Observable, throwError } from 'rxjs';

const TOKEN_HEADER_KEY = 'Authorization';       // for Spring Boot back-end

@Injectable()
export class AdminInterceptor implements HttpInterceptor {
  constructor(private token: TokenStorageService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    const token = this.token.getToken();
    if (token != null) {
      // for Spring Boot back-end
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, token) });
    }
    return next.handle(authReq).pipe( 

    catchError((error: HttpErrorResponse) => {
      if (error.status === 401 || error.status === 403) {
        // auto logout if 401 response returned from api
        window.location.href = "/admin/sign-in";
        this.token.signOut();
      }
      const err = error.error.message || error.statusText;
      return throwError(err);
    })
    )
  }

}

export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AdminInterceptor, multi: true }
];