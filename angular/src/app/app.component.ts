import { Component } from '@angular/core';
import { AuthService } from './services/auth.service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jobs';

  constructor(private authService: AuthService){
    authService.handleAuthentication();
  }
}
