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
import { Route, RouterModule, Routes } from '@angular/router';
import { SuccessComponent } from './success/success.component';
import { DeleteEmployeeComponent } from './delete-employee/delete-employee.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';
import { EmpGuard } from './emp.guard';

let routesConfig :Routes =[
  {path :'', component : FetchEmployeesComponent},
  {path :'getAll', component : FetchEmployeesComponent},
  {path :'getById', component : FetchEmployeeComponent },
  {path : 'store', component : StoreEmployeeComponent},
  {path : 'update/:emp', component : UpdateEmployeeComponent},
  {path : 'delete/:emp', component : DeleteEmployeeComponent},
  {path : 'tdfDemo', component : TdfDemoComponent},
  {path : 'mdfDemo', component : MdfDemoComponent},
  {path : 'success/:un', component : SuccessComponent, canActivate :[EmpGuard], children :[
    {path : '', component : DashboardComponent},{path :'dashboard', component : DashboardComponent},
    {path :'settings' ,component : SettingsComponent},{path :'profile' ,component :ProfileComponent}
  ]}
]


@NgModule({
  declarations: [
    AppComponent,
    TdfDemoComponent,
    MdfDemoComponent,
    FetchEmployeeComponent,
    FetchEmployeesComponent,
    StoreEmployeeComponent,
    UpdateEmployeeComponent,
    SuccessComponent,
    DeleteEmployeeComponent,
    DashboardComponent,
    ProfileComponent,
    SettingsComponent
  ],
  imports: [
    BrowserModule, FormsModule, ReactiveFormsModule, HttpClientModule ,
    RouterModule.forRoot(routesConfig)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
