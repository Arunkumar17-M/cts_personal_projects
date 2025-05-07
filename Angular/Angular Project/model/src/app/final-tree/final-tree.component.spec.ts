import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalTreeComponent } from './final-tree.component';

describe('FinalTreeComponent', () => {
  let component: FinalTreeComponent;
  let fixture: ComponentFixture<FinalTreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinalTreeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinalTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
