import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  baseURL = "http://localhost:9092";
  constructor(private _client : HttpClient) {

   }

   //Get all employees
   fetchEmployees() : Observable<any> {
      let url = `${this.baseURL}/employee`;
      return this._client.get(url);
   }

   //Get Employee By Id
   fetchEmployeeById(empID : number) : Observable<any> {
     console.log("Inside fetchEmployeeById") 
      let url = `${this.baseURL}/employee/${empID}`
      return this._client.get(url)
   }

   //Insert Employee into DB
   store(employeeInfo : any) : Observable<any> {
     console.log("Inside store")
    let url = `${this.baseURL}/employee`; 
    return this._client.post(url,employeeInfo);
   }

   //update Employee details
   updateSalary(employeeInfo : any) : Observable<any> {
    let url = `${this.baseURL}/employee`;  
    return this._client.put(url,employeeInfo)  //put- 2nd arg takes body
   }
}
