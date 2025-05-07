import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoWaybindingComponent } from './two-waybinding.component';

describe('TwoWaybindingComponent', () => {
  let component: TwoWaybindingComponent;
  let fixture: ComponentFixture<TwoWaybindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoWaybindingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TwoWaybindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
