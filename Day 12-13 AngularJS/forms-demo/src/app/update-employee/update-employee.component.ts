import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ConnectableObservable } from 'rxjs';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(private _service :EmployeeService , private _builder : FormBuilder) { }

  ngOnInit(): void {
  }

  employee = this._builder.group({
    id : [],
    salary : [] 
  })

  success :any = undefined
  err :any = undefined
  handleClick(): void {
    
    let employeeData = [
      {
        '_id' : this.employee.controls['id'].value
      },
      { '$set' :{
        'salary' : this.employee.controls['salary'].value
      }}
    ]
    let jsonObj = JSON.stringify(employeeData)

    let jsonToJS = JSON.parse(jsonObj)
    this._service.updateSalary(employeeData).subscribe((response) => {
                                                  console.log(response)
                                                  this.success = response
                                                  console.log(this.success)
    },(err) => {
              console.log(err)
              this.err = err.error.error;
              //console.log(this.err)
    })
  }

}
