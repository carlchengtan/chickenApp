import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChickensComponent } from './chickens.component';

describe('ChickensComponent', () => {
  let component: ChickensComponent;
  let fixture: ComponentFixture<ChickensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChickensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChickensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
