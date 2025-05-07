import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film, ListfilmServiceService } from '../service/data/listfilm-service.service';

@Component({
  selector: 'app-show-film',
  templateUrl: './show-film.component.html',
  styleUrls: ['./show-film.component.css']
})
export class ShowFilmComponent implements OnInit{
  public film! : Film;
  public id! : any;
  public filmid! : any;
  constructor(
    private route: ActivatedRoute,
    private filmservice : ListfilmServiceService
  ){
    this.film=new Film();
    this.id=sessionStorage.getItem('id');
    this.filmid=this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.filmservice.getSpecificFilmBackend(this.id,this.filmid).subscribe(
      data=> this.film=data
    )
  }
}
