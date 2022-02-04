import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpGuard implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot,state: RouterStateSnapshot): boolean{

    //get session storage object
    const username = sessionStorage.getItem("username")
    let un = route.paramMap.get('un')
    if(username==un){
        //console.log(un)
        return true;
    }else{
      alert("Kindly login again")
      return false
    }
  }
  
}
