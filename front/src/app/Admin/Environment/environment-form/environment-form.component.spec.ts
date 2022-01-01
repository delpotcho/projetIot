import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnvironmentFormComponent } from './environment-form.component';

describe('EnvironmentFormComponent', () => {
  let component: EnvironmentFormComponent;
  let fixture: ComponentFixture<EnvironmentFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnvironmentFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnvironmentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
