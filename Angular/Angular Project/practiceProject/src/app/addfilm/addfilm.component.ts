import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Film, ListfilmServiceService } from '../service/data/listfilm-service.service';

@Component({
  selector: 'app-addfilm',
  templateUrl: './addfilm.component.html',
  styleUrls: ['./addfilm.component.css']
})
export class AddfilmComponent implements OnInit{
  customerId! : any;
  filmid!: number;
  film!: Film;
  watchedtemp! : any;
  temp!: boolean;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public filmService : ListfilmServiceService
  ){
    this.film = new Film();
    this.filmid = this.route.snapshot.params['id'];
    this.customerId = sessionStorage.getItem('id');
  }

  ngOnInit(): void {
    if(typeof this.filmid == 'undefined'){
      this.temp=false;
    }else{
      this.temp=true;
      this.filmService.getSpecificFilmBackend(this.customerId, this.filmid).subscribe(
        data=> this.film=data
      )
    }
  }

  saveFilm(){
    this.film.watched=(this.watchedtemp === 'true')? true : false;
    if(typeof this.filmid == 'undefined'){
      this.filmService.postData(this.customerId, this.film).subscribe(
        data => 
        this.router.navigate(['home']) // always put the line inside subscribe otherwise
        // data will come before the update or post.
      );
    }else{
      this.filmService.updateData(this.customerId, this.filmid, this.film).subscribe(
        data=> this.router.navigate(['home'])
      );
    }
  }
}
