import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {TeamService} from "@team-handling/teams/services/team.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Team} from "@team-handling/teams/models/team";

@Component({
  selector: 'app-team-delete-page',
  templateUrl: './team-delete-page.component.html',
  styleUrls: ['./team-delete-page.component.scss']
})
export class TeamDeletePageComponent implements OnInit {
  id: any;
  team: any;

  constructor(
              private teamService: TeamService,
              private route: ActivatedRoute,
              private router: Router,
  ) {
    this.id = this.route.snapshot.paramMap.get(`id`);
  }

  ngOnInit(): void {
    this.teamService.pullTeam().subscribe(team => this.team = team );
  }
  deleteTeam(){

    this.teamService
      .deleteTeam(this.id)
      .subscribe(_ => this.router.navigate(['teams']));
  }

  back() : void{
    this.router.navigate([`teams`])
  }
}
