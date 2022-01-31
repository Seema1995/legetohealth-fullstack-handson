import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-store-employee',
  templateUrl: './store-employee.component.html',
  styleUrls: ['./store-employee.component.css']
})
export class StoreEmployeeComponent implements OnInit {

  constructor(private _service : EmployeeService ,private _builder : FormBuilder) { }

  ngOnInit(): void {
  }

  employee = this._builder.group({
    id :[],
    name :[],
    salary : []
  })
  
  err :any = undefined
  success : any = undefined
  
  handleClick() :void {
    let employeeData :object = []
    let myId = this.employee.controls['id'].value;
    let myName = this.employee.controls['name'].value;
    let mySalary = this.employee.controls['salary'].value;
    employeeData = [{
      id : myId,
      name : myName,
      salary : mySalary
    }]
    let jsonObj = JSON.stringify(employeeData)
    console.log(jsonObj)
    this._service.store(jsonObj).subscribe((response) => {
                                                    console.log(response)
                                                    this.success = response
                                                  },(err) => {
                                                    console.log(err.error.error)
                                                    this.err = err.error.error
                                                  })
  }

}
