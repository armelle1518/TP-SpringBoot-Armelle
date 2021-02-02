import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatCardModule} from "@angular/material/card";
import {TeamDetailPageComponent} from "@team-handling/teams/containers/team-detail-page/team-detail-page.component";
import {TeamListPageComponent} from "@team-handling/teams/containers/team-list-page/team-list-page.component";
import { TeamAddPageComponent } from './containers/team-add-page/team-add-page.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import { TeamUpdatePageComponent } from './containers/team-update-page/team-update-page.component';
import { TeamDeletePageComponent } from './containers/team-delete-page/team-delete-page.component';


@NgModule({
  declarations: [
    TeamListPageComponent,
    TeamDetailPageComponent,
    TeamAddPageComponent,
    TeamUpdatePageComponent,
    TeamDeletePageComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,


    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule


  ]
})
export class TeamsModule {
}
