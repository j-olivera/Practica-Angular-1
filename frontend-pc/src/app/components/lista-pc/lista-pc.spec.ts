import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPc } from './lista-pc';

describe('ListaPc', () => {
  let component: ListaPc;
  let fixture: ComponentFixture<ListaPc>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaPc],
    }).compileComponents();

    fixture = TestBed.createComponent(ListaPc);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
