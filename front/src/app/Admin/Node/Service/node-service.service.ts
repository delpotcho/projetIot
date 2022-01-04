import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NodeData } from '../../Environment/Service/environment.service';

@Injectable({
  providedIn: 'root'
})
export class NodeServiceService {
  private url: string = 'http://localhost:8080';

  constructor(private http:HttpClient) {

   }

   getNodesDataHour():Observable<NodeData[]>{
     return this.http.get<NodeData[]>(this.url+"/node/data/hours",{withCredentials:true})
   }
}
