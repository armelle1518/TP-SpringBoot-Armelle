import {Component, OnInit} from '@angular/core';
import {Team} from "@team-handling/teams/models/team";
import {TeamService} from "@team-handling/teams/services/team.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-team-update-page',
  templateUrl: './team-update-page.component.html',
  styleUrls: ['./team-update-page.component.scss']
})
export class TeamUpdatePageComponent implements OnInit {

  addTeamForm!: FormGroup;
  name: string | null ="";
  slogan: string | null;
  id: any;

  constructor(private fb: FormBuilder,
              private teamService: TeamService,
              private route: ActivatedRoute,
              private router: Router,
              ) {
    this.name = this.route.snapshot.paramMap.get(`name`);
    this.slogan = this.route.snapshot.paramMap.get(`slogan`);
    this.id = this.route.snapshot.paramMap.get(`id`);
  }

  ngOnInit(): void {

    this.createForm();
  }

  updateTeam(){
    if (this.addTeamForm.invalid) {
      return
    }

    const team: Team = {

      name: this.addTeamForm.value.name,
      slogan: this.addTeamForm.value.slogan,
      id: this.id
    };

  console.log(team.id);
    this.teamService
      .updateTeam(team)
      .subscribe(_ => this.router.navigate(['teams']));
  }


  private createForm(): void {

    this.addTeamForm = this.fb.group({
      name: ['', Validators.required],
      slogan: ['', Validators.required]
    });
  }

  cancel() {
    this.router.navigate([`teams`])
  }
}
