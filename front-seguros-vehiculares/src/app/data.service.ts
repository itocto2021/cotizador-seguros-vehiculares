import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  dataUrl= '';

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(`${this.dataUrl}`);
  }
}
