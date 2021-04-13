import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MatchesComponent } from './matches/matches.component';
import { TeamsComponent } from './teams/teams.component';

import { AppService } from './app.service';
import {Ng2OrderModule} from "ng2-order-pipe";
import {FormsModule} from "@angular/forms";  // to ordered


const routes: Routes = [
  {
    path : 'teams',
    component : TeamsComponent
  },
  {
    path : 'matches',
    component : MatchesComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    MatchesComponent,
    TeamsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    Ng2OrderModule,
    FormsModule
  ],
  providers: [
    AppService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
