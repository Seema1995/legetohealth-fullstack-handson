import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tdf-demo',
  templateUrl: './tdf-demo.component.html',
  styleUrls: ['./tdf-demo.component.css']
})
export class TdfDemoComponent implements OnInit {

  constructor(private _router :Router, private _builder :FormBuilder) { }

  ngOnInit(): void {
  }

  handleSubmit(formData :any): void{
    console.log(formData)
    if(formData.un =="Alexis"){
      this._router.navigate(["success"])
    }else{
      this._router.navigate(["mdfDemo"])
      formData.reset()
    }
  }
}
