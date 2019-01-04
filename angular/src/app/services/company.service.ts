import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';

const httpOptions={
headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CompanyService {
  
  constructor(private http: HttpClient) { 
  }

  getCompanies(){
    return this.http.get('/server/companies');
  }

  getCompany(id: number){
    let token= localStorage.getItem("access_token");
    return this.http.get('/server/companies/'+ id, {headers: new HttpHeaders().set('Authorization', 'Bearer '+ token)}
    );
  }

  createCompany(company){
    let token= localStorage.getItem("access_token");
    let body= JSON.stringify(company);
    return this.http.post('/server/companies', body, {headers: new HttpHeaders({'Content-Type': 'application/json'}).set('Authorization', 'Bearer '+ token)});
  }
}
