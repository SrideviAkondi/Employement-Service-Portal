import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../../services/company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {
  public companies;
  title: String = "List of companies";
  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.getCompanies();
  }

  getCompanies(){
    this.companyService.getCompanies().subscribe(
      data=> {this.companies= data},
      err => console.log(err),
      ()=> console.log('companies loaded')
    );
  }
}
