import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-createcompany',
  templateUrl: './createcompany.component.html',
  styleUrls: ['./createcompany.component.css']
})
export class CreatecompanyComponent implements OnInit {
  companyForm: FormGroup;
  validMessage: string= "";
  constructor(private company: CompanyService) { }

  ngOnInit() {
    this.companyForm= new FormGroup({
      name: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    })
  }

  submitCompany(){
    if(this.companyForm.valid){
      this.validMessage= "Company has been added to portal succesfully. Thankyou";
      this.company.createCompany(this.companyForm.value).subscribe(
        
          data=>
          { 
            this.companyForm.reset();
            return true;
          },
          err=> console.log(err),
          ()=> console.log("company loaded")
        
      )
    }
    else{
      this.validMessage= "Please fill out the form correctly before submitting!";
    }
  }
}
