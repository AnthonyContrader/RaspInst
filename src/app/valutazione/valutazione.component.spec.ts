import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValutazioneComponent } from './valutazione.component';

describe('ValutazioneComponent', () => {
  let component: ValutazioneComponent;
  let fixture: ComponentFixture<ValutazioneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValutazioneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValutazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
