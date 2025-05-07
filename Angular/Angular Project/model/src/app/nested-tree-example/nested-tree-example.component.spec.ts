import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NestedTreeExampleComponent } from './nested-tree-example.component';

describe('NestedTreeExampleComponent', () => {
  let component: NestedTreeExampleComponent;
  let fixture: ComponentFixture<NestedTreeExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NestedTreeExampleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NestedTreeExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
