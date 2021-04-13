import {Component, DoCheck, OnInit} from '@angular/core';
import {Router} from "@angular/router";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit,DoCheck {

  constructor(private router: Router) {}

  // navigate refresh with default component
  ngOnInit() {
    this.router.navigate(['teams'])
  }

  // for navigation bar
  checked = 0;
  ngDoCheck() {
    console.log(++this.checked);
  }
}
