import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LogoutComponent } from './logout/logout.component';
import { ListfilmComponent } from './listfilm/listfilm.component';
import { HttpIntercepterService } from './service/http/http-intercepter.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ShowFilmComponent } from './show-film/show-film.component';
import { AddfilmComponent } from './addfilm/addfilm.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    LogoutComponent,
    ListfilmComponent,
    ShowFilmComponent,
    AddfilmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
