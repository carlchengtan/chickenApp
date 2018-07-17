import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChickenEditComponent } from './chicken-edit.component';

describe('ChickenEditComponent', () => {
  let component: ChickenEditComponent;
  let fixture: ComponentFixture<ChickenEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChickenEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChickenEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
