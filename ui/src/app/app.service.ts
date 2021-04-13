import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

/**
 * Class representing application service.
 *
 * @class AppService.
 */
@Injectable()
export class AppService {

  constructor(private http: HttpClient) {}

  // to get football clubs details
  getTeams(): Observable<any>{
    return this.http.get("http://localhost:9000/api/clubDetails")
  }

  // get played matches
  getPlayedMatches(): Observable<any>{
    return this.http.get("http://localhost:9000/api/playedMatches")
  }

  // get add played match
  sendPlayedMatch(): Observable<any>{
    return this.http.post("/api/playedMatches/addMatch" , {})
  }
}
