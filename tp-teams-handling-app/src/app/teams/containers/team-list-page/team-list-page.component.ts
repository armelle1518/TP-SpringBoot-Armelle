import { Component, OnInit } from '@angular/core';
import {Team} from "@team-handling/teams/models/team";
import {TeamService} from "@team-handling/teams/services/team.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-team-list-page',
  templateUrl: './team-list-page.component.html',
  styleUrls: ['./team-list-page.component.scss']
})
export class TeamListPageComponent implements OnInit {

  teams:Team[] | [];

  constructor(private teamService: TeamService,
              private router: Router,
              private route: ActivatedRoute) {
    this.teams = [];
  }

  ngOnInit(): void {
    this.teamService.getTeams().subscribe(teams => this.teams =  teams);
  }


  onSelectTeam(team : Team) : void{
    this.teamService.pushTeam(team);
    this.router.navigate([`teams/${team.id}`]);
  }

  add() {
    this.router.navigate([`teams/create`])
  }

  update(team: Team) {

    this.router.navigate([`teams/${team.name}/${team.slogan}/${team.id}`])

  }

  delete(team: Team) {
    this.teamService.pushTeam(team);
    this.router.navigate([`teams/d/${team.id}`]);
  }
}
