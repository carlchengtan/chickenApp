import { TestBed, inject } from '@angular/core/testing';

import { TanService } from './tan.service';

describe('TanService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TanService]
    });
  });

  it('should be created', inject([TanService], (service: TanService) => {
    expect(service).toBeTruthy();
  }));
});
