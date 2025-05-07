import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {ButtonModule} from 'primeng/button';
import {MenubarModule} from 'primeng/menubar';
import {PanelMenuModule} from 'primeng/panelmenu';
import {SidebarModule} from 'primeng/sidebar';
import {AppRoutingModule} from './app-routing.module';
import {ExamplePageComponent} from './example-page/example-page.component';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {FooterComponent} from './footer/footer.component';
import {HeaderComponent} from './header/header.component';
import {NgxFrfUtilitiesModule} from '@wame/ngx-frf-utilities';
import {NgxAdfsModule, HttpRequestInterceptor, UserIdService} from '@wame/ngx-adfs';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {environment} from '../environments/environment';

@NgModule({
	declarations: [
		AppComponent,
		NavComponent,
		ExamplePageComponent,
		FooterComponent,
		HeaderComponent
	],
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		RouterModule,
		AppRoutingModule,
		ButtonModule,
		MenubarModule,
		PanelMenuModule,
		SidebarModule,
		ToastModule,
		NgxFrfUtilitiesModule,
		NgxAdfsModule.forRoot({
			openidUrl: environment.openidUrl,
			openidClientId: environment.openidClientId,
			openidResource: environment.openidResource
		})
	],
	providers: [
		MessageService,
		UserIdService,
		{
			provide: HTTP_INTERCEPTORS,
			useClass: HttpRequestInterceptor,
			multi: true
		}
	],
	bootstrap: [AppComponent]
})
export class AppModule {}
