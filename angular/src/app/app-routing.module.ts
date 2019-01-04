import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompaniesComponent } from './controllers/companies/companies.component';
import { CreatecompanyComponent } from './controllers/companies/createcompany/createcompany.component';
import { ViewcompanyComponent } from './controllers/companies/viewcompany/viewcompany.component';
import { CallbackComponent } from './controllers/callback/callback.component';
import { AuthGuardService } from './services/auth.guard.service';

const routes: Routes = [{
  path: 'companies',
  component: CompaniesComponent
},
{
  path: 'companies/create',
  component: CreatecompanyComponent,
  canActivate: [AuthGuardService]
},
{
  path: 'companies/view/:id',
  component: ViewcompanyComponent,
  canActivate: [AuthGuardService]
},
{
  path: 'callback',
  component: CallbackComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
