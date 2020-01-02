import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmailComponent } from './email/email.component';



const routes: Routes = [
  //{path : '', component:EmailComponent, pathMatch: 'full'},
  //{path : 'employee-address', component:EmployeeAddressComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
