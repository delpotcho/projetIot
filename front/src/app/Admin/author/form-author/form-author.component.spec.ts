import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAuthorComponent } from './form-author.component';

describe('FormAuthorComponent', () => {
  let component: FormAuthorComponent;
  let fixture: ComponentFixture<FormAuthorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormAuthorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAuthorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
