import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }
  name :string = "Jim Smith";
  salary:number = 25000;
  dob:Date = new Date(1995,9,4);
  fruits:any = ["Papaya","Mango","Watermelon"];
  status:boolean = true;


}
