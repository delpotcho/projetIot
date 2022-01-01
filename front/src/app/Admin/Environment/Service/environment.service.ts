import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Environment {
  name: String;
  minTemperature: number;
  maxTemperature: number;
  minHumidity: number;
  maxHumidity: number;
  nodes: string;
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

  public newEnvironment(environment: Environment) {
    return this.http.post<Environment>(
      this.url + '/environment/new',
      environment,
      { withCredentials: true }
    );
  }
}
