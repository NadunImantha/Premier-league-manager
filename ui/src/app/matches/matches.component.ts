import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

export class matches {
  playedDate: string;
  ATeam: string;
  BTeam: string
  ATeamScore: number;
  BTeamScore: number;
}

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit{

  constructor(private _appService: AppService) {}

  PlayedDate: any;
  listOfMatches: matches[];

  ngOnInit() {
    this._appService.getPlayedMatches().subscribe(data=>{
      this.listOfMatches = data;
    })
  }

  // search bar
  search(){
    if (this.PlayedDate == ""){
      this.ngOnInit()
    }
    else {
      this.listOfMatches = this.listOfMatches.filter(reset => {
        return reset.playedDate.toLocaleLowerCase().match(this.PlayedDate.toLocaleLowerCase())
      })
    }
  }

  // add played match
  addMatch(){
    this._appService.sendPlayedMatch().subscribe(data => {
      this.listOfMatches = data;
    })
  }
}
