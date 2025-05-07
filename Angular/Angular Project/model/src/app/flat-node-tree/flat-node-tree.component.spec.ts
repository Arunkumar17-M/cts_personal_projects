import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlatNodeTreeComponent } from './flat-node-tree.component';

describe('FlatNodeTreeComponent', () => {
  let component: FlatNodeTreeComponent;
  let fixture: ComponentFixture<FlatNodeTreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlatNodeTreeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FlatNodeTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
