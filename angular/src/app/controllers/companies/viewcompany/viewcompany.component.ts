import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-viewcompany',
  templateUrl: './viewcompany.component.html',
  styleUrls: ['./viewcompany.component.css']
})
export class ViewcompanyComponent implements OnInit {

  public viewCompany;
  constructor(private company: CompanyService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getEachCompany(this.route.snapshot.params.id);
  }

  getEachCompany(id: number){
    this.company.getCompany(id).subscribe(
      data=>{
        this.viewCompany= data;
      },
      err=> console.log(err),
      ()=> console.log(this.viewCompany.name)
    );
  }

}
