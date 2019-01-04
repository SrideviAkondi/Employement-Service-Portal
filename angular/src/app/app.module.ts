import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompaniesComponent } from './controllers/companies/companies.component';
import {CompanyService} from './services/company.service';
import {HttpClientModule} from '@angular/common/http';
import { CreatecompanyComponent } from './controllers/companies/createcompany/createcompany.component';
import { ViewcompanyComponent } from './controllers/companies/viewcompany/viewcompany.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CallbackComponent } from './controllers/callback/callback.component';
import { AuthService } from './services/auth.service.service';
import { AuthGuardService } from './services/auth.guard.service';


@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    CreatecompanyComponent,
    ViewcompanyComponent,
    CallbackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CompanyService, AuthService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
