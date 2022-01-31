import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-mdf-demo',
  templateUrl: './mdf-demo.component.html',
  styleUrls: ['./mdf-demo.component.css']
})
export class MdfDemoComponent implements OnInit {

  constructor(private _builder :FormBuilder){

  }

  ngOnInit(): void {
  }

  profile = this._builder.group({
    firstname : ['',Validators.compose([Validators.required,Validators.minLength(5)])],
    lastname : ['',Validators.compose([Validators.required,Validators.minLength(7)])]
  })

  handleSubmit() : void{
    console.log(this.profile.value)
  }

}
