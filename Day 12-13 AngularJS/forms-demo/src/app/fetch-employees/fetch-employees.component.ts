import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ConnectableObservable } from 'rxjs';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-fetch-employees',
  templateUrl: './fetch-employees.component.html',
  styleUrls: ['./fetch-employees.component.css']
})
export class FetchEmployeesComponent implements OnInit {

  constructor(private _service:EmployeeService , private _builder:FormBuilder , private _router : Router) {
    
   }

  ngOnInit(): void {
    this._service.fetchEmployees().subscribe((response) => {
      this.emp = response
    },
    (err) => {
      console.log(err);
      this.err = err.error.error;
    })
  }

  employee = this._builder.group({
   // id : [], name :[] , salary :[]
  })

  emp :any  = undefined
  err :any = undefined

  handleClick() :void {

    
  }

  deleteEmp(emp : any) :void {
    this._router.navigate(["delete",emp])
  }

  editEmp(emp : any) : void {
    this._router.navigate(["update",emp])
  }

}

