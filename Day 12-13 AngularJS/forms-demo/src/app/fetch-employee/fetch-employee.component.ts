import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-fetch-employee',
  templateUrl: './fetch-employee.component.html',
  styleUrls: ['./fetch-employee.component.css']
})
export class FetchEmployeeComponent implements OnInit {

  constructor(private _service : EmployeeService , 
    private _builder : FormBuilder) { }

  ngOnInit(): void {
  }
  
  employee = this._builder.group({
    id : [], name : [] ,salary : []
  })

  emp : any = undefined
  err : any  = undefined

  handleClick() : void {
    
    let id = this.employee.controls['id'].value;
    //console.log("id to be searched is "+id)
    this._service.fetchEmployeeById(id).subscribe(
      (response) => {
          console.log(response)
          this.emp = response;
          this.err = undefined;
      },
      (err) => {
          console.log(err)
          this.err = err.error.error
          this.emp = undefined;
      }
    );

    this.employee.reset({});
  }//handleClick Ends


}
