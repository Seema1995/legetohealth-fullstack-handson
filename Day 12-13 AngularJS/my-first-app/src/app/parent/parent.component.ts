import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  firstname = "Seema"
  users = [{name : "Jack"},
          {name : "Jill" },
          {name : "Samuel"},
          {name : "Erica"}
          ]
  clicks :number =0
  numberOfClicks(value :any){
    this.clicks = this.clicks+value;
  }

}
