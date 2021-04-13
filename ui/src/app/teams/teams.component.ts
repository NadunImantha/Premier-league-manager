import { Component, OnInit } from '@angular/core';
import {AppService} from "../app.service";

export class clubs{
  clubName: string;
  noOfWins: number;
  noOfDraws: number;
  noOfDefeats: number;
  noOfScoredGoals: number;
  noOfPoints: number;
  noOfPlayedMatches: number;
}

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  constructor(private appService: AppService) {}
  listOfClubs: clubs[];

  ngOnInit() {
    this.appService.getTeams().subscribe(data=>{
      this.listOfClubs = data;
    })
  }

  // sort function
  key: string = '';
  sort(key){
    this.key = key;
  }
}
