import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddfilmComponent } from './addfilm/addfilm.component';
import { ListfilmComponent } from './listfilm/listfilm.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/route-guard.service';
import { ShowFilmComponent } from './show-film/show-film.component';

const routes: Routes = [
  { path: '', component: LoginComponent},
  {path: 'login/:name', component: LoginComponent},
  {path: 'register/:name', component: LoginComponent},
  {path: 'home',component: ListfilmComponent, canActivate : [RouteGuardService]},
  {path: 'home/showdata/:id', component: ShowFilmComponent, canActivate : [RouteGuardService]},
  {path: 'add', component: AddfilmComponent, canActivate : [RouteGuardService]},
  {path: 'update/:id', component: AddfilmComponent, canActivate : [RouteGuardService]},
  {path: 'logout', component: LogoutComponent,canActivate : [RouteGuardService]}
  // {path: 'register'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
