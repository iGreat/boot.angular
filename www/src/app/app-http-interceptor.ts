import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";

@Injectable()
export class AppHttpInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let oldUrl = req.url;
    if (oldUrl.startsWith("/"))
      oldUrl = oldUrl.substr(1);

    const reqClone = req.clone({
      url: 'http://localhost:8080/' + oldUrl
    });
    return next.handle(reqClone);
  }
}
