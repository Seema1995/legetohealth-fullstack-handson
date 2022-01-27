import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'employee-app',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }
  
  employees = [
    {id: 100, name : "Alex", salary: 45000}, 
    {id: 200, name: "Alex", salary:4000}
 ]
 

}
