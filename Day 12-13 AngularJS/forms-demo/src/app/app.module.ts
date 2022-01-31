import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TdfDemoComponent } from './tdf-demo/tdf-demo.component';
import { MdfDemoComponent } from './mdf-demo/mdf-demo.component';
import {HttpClientModule} from '@angular/common/http';
import { FetchEmployeeComponent } from './fetch-employee/fetch-employee.component';
import { FetchEmployeesComponent } from './fetch-employees/fetch-employees.component';
import { StoreEmployeeComponent } from './store-employee/store-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    TdfDemoComponent,
    MdfDemoComponent,
    FetchEmployeeComponent,
    FetchEmployeesComponent,
    StoreEmployeeComponent,
    UpdateEmployeeComponent
  ],
  imports: [
    BrowserModule, FormsModule, ReactiveFormsModule, HttpClientModule ,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
