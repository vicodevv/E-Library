import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class HttpHeadersInterceptor implements HttpInterceptor{
    constructor() {}

    intercept(
        req: HttpRequest<any>,
        next: HttpHandler
        ): Observable<HttpEvent<any>> {
            req = req.clone({
                setHeaders: {
                    'x-rapidapi-key': '8a1dce5207msh65529b046371b24p10ad29jsnef316b704304',
                    'x-rapidapi-host': 'rawg-video-games-database.p.rapidapi.com'
                },
                setParams: {
                    key: 'e40e743af2c94b0c916a8aa618fb4473'
                }
            });
            return next.handle(req);
        }

}