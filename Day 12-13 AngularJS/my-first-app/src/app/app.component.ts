import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-first-app';

  users = [{name : "Jack" , gender : "Male"},
          {name : "Jill" , gender : "Female"},
          {name : "Samuel" ,gender : "Male"},
          {name : "Erica" ,gender : "Female"}
          ]
}
