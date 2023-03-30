import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { APIResponse, Game } from 'src/app/models';
import { HttpService } from 'src/app/service/http.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  public sort: string = 'relevance';
  public games!: Array<Game>;
  private routeSubscribtion!: Subscription;
  private gameSubscribtion!: Subscription;

  constructor(
    private httpService: HttpService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.routeSubscribtion = this.activatedRoute.queryParams.subscribe((params: Params) => {
      if (params['game-search']) {
        this.searchGames('metacrit',params['game-search']);
      }
      else{
        this.searchGames('metacrit');
      }
    });
  }

  searchGames(sort: string, search?: string): void {
    this.gameSubscribtion = this.httpService
      .getGameList(sort, search)
      .subscribe((gameList: APIResponse<Game>) => {
        this.games = gameList.results;
        console.log(gameList);
      });
  }

  openGameDetails(id: string): void {
    this.router.navigate(['details', id]);
  }

  ngOnDestroy(): void {
    if (this.routeSubscribtion) {
      this.routeSubscribtion.unsubscribe();
    }
    if (this.gameSubscribtion) {
      this.gameSubscribtion.unsubscribe();
    }
  }
}

