import {TestBed} from '@angular/core/testing';

import {AppComponent} from './app.component';
import {
	RouterLinkStubDirective,
	RouterOutletStubDirective,
	RouterStub
} from '../testing/router-stubs';
import {NO_ERRORS_SCHEMA} from '@angular/core';
import {By} from '@angular/platform-browser';
import {NavigationEnd, Router} from '@angular/router';
import {of} from 'rxjs';

describe('AppComponent', () => {
	let fixture, appComponent, compiled;
	const routerStub = new RouterStub();

	beforeEach(() => {
		TestBed.configureTestingModule({
			declarations: [
				AppComponent,
				//for routing we have to use some router stubs. these aren't given by angular.
				//but, the /testing/router-stubs.ts file, from google, provides the necessary mocks
				RouterLinkStubDirective,
				RouterOutletStubDirective
			],
			providers: [{provide: Router, useValue: routerStub}],
			schemas: [NO_ERRORS_SCHEMA]
		}).compileComponents();

		fixture = TestBed.createComponent(AppComponent);
		fixture.detectChanges();
		appComponent = fixture.debugElement.componentInstance;
		compiled = fixture.debugElement.nativeElement;
	});

	describe('tests:', () => {
		it('should create the app', () => {
			expect(appComponent).toBeTruthy();
		});

		describe('ngOnInit(): ', () => {
			it('should leverage the router events to dynamically construct the skip url', () => {
				spyOn(appComponent, 'setSkipLinkUrl');
				routerStub.events = of(
					new NavigationEnd(2, 'test', 'test-after-redirect')
				);
				appComponent.ngOnInit();
				expect(appComponent.setSkipLinkUrl).toHaveBeenCalledWith(
					'test-after-redirect'
				);
			});
		});

		describe('setSkipLinkUrl(): ', () => {
			it('should use the passed in url to appropriately set the skip url', () => {
				appComponent.skipToMain = 'someurl';
				appComponent.setSkipLinkUrl('test#app-content');
				expect(appComponent.skipToMain).toEqual('someurl');
				appComponent.setSkipLinkUrl('test');
				expect(appComponent.skipToMain).toEqual('test#app-content');
			});
		});

		describe('template tests: ', () => {
			it('should include a header, main content section and footer', () => {
				expect(compiled.querySelector('#app-header').tagName).toEqual(
					'HEADER'
				);
				expect(compiled.querySelector('#app-content').tagName).toEqual(
					'MAIN'
				);
				expect(compiled.querySelector('#footer').tagName).toEqual(
					'FOOTER'
				);
			});

			it('should have the toast component included and properly configured', () => {
				expect(
					fixture.debugElement.query(By.css('p-toast')).nativeElement
						.tagName
				).toEqual('P-TOAST');
			});

			it('should include the nav component in the header', () => {
				//equiv to fixture.debugElement.query(By.css('#app-header app-nav'))
				expect(
					compiled.querySelector('#app-header app-nav')
				).toBeDefined();
			});

			it('should include a skip to main link before other items in the header', () => {
				spyOn(appComponent, 'setSkipLinkUrl').and.callThrough();
				routerStub.events = of(
					new NavigationEnd(2, 'test', 'testurl-after-redirect')
				);

				appComponent.ngOnInit();

				fixture.detectChanges();
				expect(appComponent.setSkipLinkUrl).toHaveBeenCalledWith(
					'testurl-after-redirect'
				);
				expect(
					compiled.querySelector('#app-header').firstChild.tagName
				).toEqual('A');
				expect(
					compiled.querySelector('#app-header .skip-link').textContent
				).toEqual('Skip to Content');
				expect(
					compiled
						.querySelector('#app-header .skip-link')
						.href.endsWith('/testurl-after-redirect#app-content')
				).toEqual(true);
			});
		});
	});
});
