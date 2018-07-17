import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChickenCreateComponent } from './chicken-create.component';

describe('ChickenCreateComponent', () => {
  let component: ChickenCreateComponent;
  let fixture: ComponentFixture<ChickenCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChickenCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChickenCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
