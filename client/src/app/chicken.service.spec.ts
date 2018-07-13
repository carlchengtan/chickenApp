import { TestBed, inject } from '@angular/core/testing';

import { ChickenService } from './chicken.service';

describe('ChickenService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChickenService]
    });
  });

  it('should be created', inject([ChickenService], (service: ChickenService) => {
    expect(service).toBeTruthy();
  }));
});
