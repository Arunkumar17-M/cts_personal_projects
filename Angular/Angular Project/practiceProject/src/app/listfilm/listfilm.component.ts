import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Film, ListfilmServiceService } from '../service/data/listfilm-service.service';

@Component({
  selector: 'app-listfilm',
  templateUrl: './listfilm.component.html',
  styleUrls: ['./listfilm.component.css']
})
export class ListfilmComponent implements OnInit{

  public id = sessionStorage.getItem('id');
  public film !: Film[];
  constructor(
    private filmService : ListfilmServiceService,
    public router : Router
  ){}
  ngOnInit(): void {
    this.refreshPage();
  }

  refreshPage(){
    this.filmService.getListofFilm(this.id).subscribe(
      data => {
        this.film = data;
      }
    )
  }

  addData(){
    console.log("work");
    this.router.navigate(['addData']);
  }

  deleteSpecificFilm(filmid : any, filmName : any){
    if(confirm('Are You Sure to delete this '+filmName+' film?')){
      this.filmService.deleteData(this.id, filmid).subscribe(
        data => this.refreshPage()
      );
    }
  }
}
