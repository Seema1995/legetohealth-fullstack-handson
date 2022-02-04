import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  constructor(private _activatedRoute : ActivatedRoute) { }

  username = undefined
  ngOnInit(): void {
    this._activatedRoute.parent?.params.subscribe((p) => 
      this.username = p['un']
    )
  }

}
