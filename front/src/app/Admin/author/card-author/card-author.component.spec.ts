import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAuthorComponent } from './card-author.component';

describe('CardAuthorComponent', () => {
  let component: CardAuthorComponent;
  let fixture: ComponentFixture<CardAuthorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardAuthorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardAuthorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
