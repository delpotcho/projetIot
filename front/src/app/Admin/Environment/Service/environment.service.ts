import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



export interface Node{
  id: String;
  name: String;
  environmentId:String,
  data:NodeData[]
}
export interface Environment {
  id: String;
  name:String,
  minTemperature: number;
  maxTemperature: number;
  minHumidity: number;
  maxHumidity: number;
  nodes: Node[];
}
export interface NodeData {
  id: string;
  name: string;
  temperature: number;
  humidity: number;
  dateTime: string;
}

@Injectable({
  providedIn: 'root',
})
export class EnvironmentService {
  private url: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  public getEnvironments(): Observable<any> {
    return this.http.get(this.url + '/environment/', { withCredentials: true });
  }
  public getEnvironment(id: String): Observable<any> {
    return this.http.get(this.url + '/environment/' + id, {
      withCredentials: true,
    });
  }

  public newEnvironment(environment: Environment) {
    return this.http.post<Environment>(
      this.url + '/environment/new',
      environment,
      { withCredentials: true }
    );
  }
}
