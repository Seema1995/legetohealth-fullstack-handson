import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreEmployeeComponent } from './store-employee.component';

describe('StoreEmployeeComponent', () => {
  let component: StoreEmployeeComponent;
  let fixture: ComponentFixture<StoreEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoreEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StoreEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
