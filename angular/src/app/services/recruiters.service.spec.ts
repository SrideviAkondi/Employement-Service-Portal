import { TestBed } from '@angular/core/testing';

import { RecruitersService } from './recruiters.service';

describe('RecruitersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RecruitersService = TestBed.get(RecruitersService);
    expect(service).toBeTruthy();
  });
});
