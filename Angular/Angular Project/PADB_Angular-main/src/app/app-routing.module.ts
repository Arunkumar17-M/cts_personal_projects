import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ExamplePageComponent} from './example-page/example-page.component';
import {NotFoundComponent} from '@wame/ngx-frf-utilities';
import {AuthenticationGuard, OauthCallbackComponent, OauthTokenGuard} from '@wame/ngx-adfs';

const routes: Routes = [
	{
		path: 'oauth',
		component: OauthCallbackComponent,
		canActivate: [OauthTokenGuard]
	},
	{
		path: 'example-page',
		component: ExamplePageComponent,
		title: 'Example Page',
		canActivate: [AuthenticationGuard]
	},
	{
		path: '',
		redirectTo: '/example-page',
		pathMatch: 'full'
	},
	{
		path: '404',
		component: NotFoundComponent
	},
	{
		path: '**',
		redirectTo: '/404'
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule {}
