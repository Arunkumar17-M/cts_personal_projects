import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlatedDynamicTreeComponent } from './flated-dynamic-tree.component';

describe('FlatedDynamicTreeComponent', () => {
  let component: FlatedDynamicTreeComponent;
  let fixture: ComponentFixture<FlatedDynamicTreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlatedDynamicTreeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlatedDynamicTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
