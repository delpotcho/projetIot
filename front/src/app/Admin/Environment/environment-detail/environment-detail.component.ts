import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Chart, registerables } from 'chart.js';
import { InteropObservable, interval, Observable, Observer, Subscriber } from 'rxjs';
import { NodeServiceService } from '../../Node/Service/node-service.service';
import { randomColor } from 'randomcolor';
import {
  Environment,
  EnvironmentService,
  NodeData,
} from '../Service/environment.service';
import util from '../../../Utils/utils.js';
@Component({
  selector: 'app-environment-detail',
  templateUrl: './environment-detail.component.html',
  styleUrls: ['./environment-detail.component.css'],
})
export class EnvironmentDetailComponent implements OnInit,OnDestroy {
  environment: Environment;
  envronmentId: string;
  showDataMode: string;
  addNewNode:boolean;
  temps:number[]=[];
  humidity:number[]=[];
  chartHumidity:Chart;
  charTemperature:Chart;
  datasetsTemperature: any[] = [];
  datasetsHumidity: any[] = [];
  labels:string[]=[];
  shudeled:Subscriber<number>
  inter;

  constructor(
    private envService: EnvironmentService,
    private activeRoute: ActivatedRoute,
    private nodeService: NodeServiceService
  ) {
    Chart.register(...registerables);
    this.activeRoute.params.subscribe(
      (params) => (this.envronmentId = params['id'])
    );
   
  }
 
  ngOnInit(): void {
     //get environment from server
     this.envService
     .getEnvironment(this.envronmentId)
     .subscribe((data) => {this.environment = data; this.initData()});
  }

  private setColor(key): string {
    let color = randomColor();
    localStorage.setItem(key, color);
    return color;
  }
  
  private initDatasetsTemperature(datasets) {
    
    this.environment.nodes.forEach((n) =>{
    n.data.map((d) => this.temps.push(d.temperature));
      datasets.push({
        label: n.name,
        data: this.temps,
        fill: false,
        borderColor:
          localStorage.getItem('color-' + n.name) == null
            ? this.setColor('color-' + n.name)
            : localStorage.getItem('color-' + n.name),
        tension: 0.1,
      })
    }
    );
  }

  private initDatasetsHumidity(datasets) {
    this.environment.nodes.forEach((n) =>
      datasets.push({
        label: n.name,
        data: n.data.map((d) => d.humidity),
        fill: false,
        borderColor: localStorage.getItem('color-' + n.name),
      })
    );
  }
  private drawChartTemperature(labels: string[], datasets: any[]) {
    this.charTemperature  = new Chart('chart-temp', {
      type: 'line',
      data: {
        labels: labels,
        datasets: datasets,
      },
      options: {
        plugins: {
          title: {
            display: true,
            text: 'Temperature C°',
            padding: 15,
            font: {
              size: 16,
            },
          },
          tooltip: {
            callbacks: {
              label: function (context) {
                var temp = context.parsed.y + 'C°';
                return temp;
              },
            },
          },
        },
        scales: {
          x: {
            ticks: {
              autoSkip: true,
              maxTicksLimit: 12,
            },
          },
        },
      },
    });
  }
  private drawChartHumidity(labels: string[], datasets: any[]) {
     this.chartHumidity = new Chart('chart-humidity', {
      type: 'line',
      data: {
        labels: labels,
        datasets: datasets,
      },
      options: {
        plugins: {
          title: {
            display: true,
            text: 'HUMIDITY %',
            padding: 15,
            font: {
              size: 16,
            },
          },
          tooltip: {
            callbacks: {
              label: function (context) {
                var humidity = context.parsed.y + '%';
                return humidity;
              },
            },
          },
        },
        scales: {
          x: {
            ticks: {
              autoSkip: true,
              maxTicksLimit: 12,
            },
          },
        },
      },
    });
  }

  initData(): void {
   
      /*
          show lebels (show time) based on  the largest data for node   
            ex:node1.data=['01/01/2021 10:12:00','01/01/2021 10:12:00'] & 
            node2.data=['01/01/2021 10:12:00','01/01/2021 10:12:00','01/01/2021 10:12:00']
          this case labels is data.datetime for node2
    */

       this.labels = this.environment.nodes
        ?.sort((n2, n1) => (n2.data.length > n1.data.length ? -1 : 1))[0]
        .data.map((d) => new Date(d.dateTime).toLocaleTimeString());
      /*********** initilize Datasets ***********/
      this.initDatasetsTemperature(this.datasetsTemperature);
      this.initDatasetsHumidity(this.datasetsHumidity);
      /***********End Initialise Datasets ***********/

      this.drawChartTemperature(this.labels, this.datasetsTemperature);
      this.drawChartHumidity(this.labels, this.datasetsHumidity);
    //reason to use timeout: wait to get Environment object

    //get data evrey 10s
     this.inter = interval(10000);
    let changeChart:boolean=false;
      this.shudeled = this.inter.subscribe(() => {

      this.environment.nodes.forEach((n) =>{
    
      this.nodeService.getLastNodeData(n.id).subscribe(data=>{
        console.log(this.labels[this.labels.length-1]);
        
        if(new Date(data['dateTime']).toLocaleTimeString()!=this.labels[this.labels.length-1]){

        this.datasetsTemperature=[];
        this.datasetsHumidity=[];
          this.temps.push(data['temperature']);
          this.humidity.push(data['humidity']);
          this.labels.push(new Date(data['dateTime']).toLocaleTimeString())
        
          //generete new DataSet
          this.datasetsTemperature.push({
            label: n.name,
            data: this.temps,
            fill: false,
            borderColor: localStorage.getItem('color-' + n.name),
          });
          changeChart=true;
        }
        
        
        
      })
     
    }
    );
    if(changeChart){
      this.charTemperature.destroy();
      this.drawChartTemperature(this.labels,this.datasetsTemperature);
      changeChart=false;
    }
 

      
    });
  }

  public showFormNode(){
    this.addNewNode= true;
  }
  public hideForm(){
    this.addNewNode=false;
  }
  ngOnDestroy(): void {
   this.shudeled.unsubscribe()
  }
}
