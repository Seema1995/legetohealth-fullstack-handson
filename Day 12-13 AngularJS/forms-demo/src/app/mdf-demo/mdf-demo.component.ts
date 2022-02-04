import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mdf-demo',
  templateUrl: './mdf-demo.component.html',
  styleUrls: ['./mdf-demo.component.css']
})
export class MdfDemoComponent implements OnInit {

  constructor(private _router : Router ,private _builder :FormBuilder ){

  }

  ngOnInit(): void {
  }

  employee = this._builder.group({
    firstname : ['',Validators.compose([Validators.required,Validators.minLength(3)])],
    lastname : ['',Validators.compose([Validators.required,Validators.minLength(3)])]
  })

  handleSubmit() : void{
    //console.log(this.employee.value)
    let firstname = this.employee.controls['firstname'].value;
    console.log(firstname)
    //hardcoded way of navigating using router by hardcoding the condition
    if(firstname == "Alexis"){
      sessionStorage.setItem("username",firstname)
      this._router.navigate(["success",firstname])
    }else{
      this._router.navigate(["mdfDemo"])
      this.employee.reset()
    }
  }

}
