import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-bind',
  templateUrl: './data-bind.component.html',
  styleUrls: ['./data-bind.component.css']
})
export class DataBindComponent implements OnInit {

  ngOnInit(): void {
      
  }
  username : string = "Seema"
  toggleButton : boolean = false
  message : string = ''
  
  handleClick( v : string) :void{
    this.username = v
    this.toggleButton = !this.toggleButton;
  }

}
