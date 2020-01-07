import { TestBed } from '@angular/core/testing';

import { ValutazioneService } from './valutazione.service';

describe('ValutazioneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ValutazioneService = TestBed.get(ValutazioneService);
    expect(service).toBeTruthy();
  });
});
