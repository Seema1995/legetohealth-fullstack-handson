import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

  constructor(private _service : EmployeeService ,private _builder :FormBuilder) { }

  employee = this._builder.group({
    id : []
  })

  err :any = undefined
  success :any = undefined
  ngOnInit(): void {
  }

  handleClick() :void {
    let employeeData = {
      "_id" : this.employee.controls["id"].value
    }

    let jsonData = JSON.stringify(employeeData)

    this._service.deleteEmployee(employeeData).subscribe(response => {
      this.success = response;
      this.err = undefined
    }, err => {
      this.err = err.error.error
      this.success = undefined
     
    })
    this.employee.reset({})
  }

}
