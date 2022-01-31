import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ConnectableObservable } from 'rxjs';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-fetch-employees',
  templateUrl: './fetch-employees.component.html',
  styleUrls: ['./fetch-employees.component.css']
})
export class FetchEmployeesComponent implements OnInit {

  constructor(private _service:EmployeeService , private _builder:FormBuilder) {
    
   }

  ngOnInit(): void {
  }

  employee = this._builder.group({
   // id : [], name :[] , salary :[]
  })
  emp :any  = undefined
  err :any = undefined
  handleClick() :void {

    this._service.fetchEmployees().subscribe((response) => {
      this.emp = response
    },
    (err) => {
      console.log(err);
      this.err = err.error.error;
    })
  }

}

