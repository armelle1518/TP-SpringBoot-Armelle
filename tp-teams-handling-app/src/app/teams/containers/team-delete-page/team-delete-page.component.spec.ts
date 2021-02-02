import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamDeletePageComponent } from './team-delete-page.component';

describe('TeamDeletePageComponent', () => {
  let component: TeamDeletePageComponent;
  let fixture: ComponentFixture<TeamDeletePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeamDeletePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamDeletePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
