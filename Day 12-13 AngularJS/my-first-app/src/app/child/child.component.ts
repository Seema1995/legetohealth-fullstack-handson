import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input()
  username : string = "Sanket"

  @Output()
  eventCounter :  EventEmitter<number> = new EventEmitter<number>()
  counter : number = 0;
  childCounter : number = 0;

  incrementCounter(){
    this.counter = this.counter + 1;
    this.childCounter++;
    this.eventCounter.emit(this.counter)
    this.counter = 0;
  }

}
