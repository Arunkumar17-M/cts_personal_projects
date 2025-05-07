import { TestBed } from '@angular/core/testing';

import { ListfilmServiceService } from './listfilm-service.service';

describe('ListfilmServiceService', () => {
  let service: ListfilmServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListfilmServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
