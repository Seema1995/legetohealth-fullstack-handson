import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private _activatedRoute : ActivatedRoute) { }

  username = undefined
  ngOnInit(): void {
    this._activatedRoute.parent?.params.subscribe((p) => 
      this.username = p['un'])  
  }

}
