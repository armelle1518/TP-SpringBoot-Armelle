import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamUpdatePageComponent } from './team-update-page.component';

describe('TeamUpdatePageComponent', () => {
  let component: TeamUpdatePageComponent;
  let fixture: ComponentFixture<TeamUpdatePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeamUpdatePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamUpdatePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
