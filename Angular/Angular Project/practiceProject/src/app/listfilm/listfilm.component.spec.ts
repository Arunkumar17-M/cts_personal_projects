import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListfilmComponent } from './listfilm.component';

describe('ListfilmComponent', () => {
  let component: ListfilmComponent;
  let fixture: ComponentFixture<ListfilmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListfilmComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListfilmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
