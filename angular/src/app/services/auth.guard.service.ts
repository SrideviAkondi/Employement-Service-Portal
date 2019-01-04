import { Injectable } from '@angular/core';
import { AuthService } from './auth.service.service';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, Route } from '@angular/router';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private authService: AuthService,  private _router: Router) { 
    }

    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      {
      if(this.authService.isAuthenticated()){
      return true;
    }
      else{
        this.authService.login();
        return false;

    }
  }
}
}

