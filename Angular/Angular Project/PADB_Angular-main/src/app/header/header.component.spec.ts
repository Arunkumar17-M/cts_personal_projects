import {ComponentFixture, TestBed} from '@angular/core/testing';

import {HeaderComponent} from './header.component';

describe('HeaderComponent', () => {
	let component: HeaderComponent;
	let fixture: ComponentFixture<HeaderComponent>;
	let compiled;

	beforeEach(async () => {
		await TestBed.configureTestingModule({
			declarations: [HeaderComponent]
		}).compileComponents();
	});

	beforeEach(() => {
		fixture = TestBed.createComponent(HeaderComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
		compiled = fixture.debugElement.nativeElement;
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});

	describe('Template Tests', () => {
		it('should have app-name h1 set', () => {
			const appLogoDiv = compiled.querySelector('#app-icon img');
			expect(appLogoDiv.alt).toEqual('Ford Oval');
		});
	});
});
