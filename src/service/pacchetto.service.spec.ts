import { TestBed } from '@angular/core/testing';

import { PacchettoService } from './pacchetto.service';

describe('PacchettoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PacchettoService = TestBed.get(PacchettoService);
    expect(service).toBeTruthy();
  });
});
