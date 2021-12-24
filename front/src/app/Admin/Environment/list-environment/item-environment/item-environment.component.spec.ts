import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemEnvironmentComponent } from './item-environment.component';

describe('ItemEnvironmentComponent', () => {
  let component: ItemEnvironmentComponent;
  let fixture: ComponentFixture<ItemEnvironmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemEnvironmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemEnvironmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
