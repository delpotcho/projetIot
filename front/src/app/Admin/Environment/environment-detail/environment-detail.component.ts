import { Component, OnInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';
import { interval } from 'rxjs';
import { EnvironmentService } from '../Service/environment.service';
@Component({
  selector: 'app-environment-detail',
  templateUrl: './environment-detail.component.html',
  styleUrls: ['./environment-detail.component.css'],
})
export class EnvironmentDetailComponent implements OnInit {
  constructor(private envService: EnvironmentService) {
    Chart.register(...registerables);
  }

  ngOnInit(): void {
    const chartTemp = new Chart('chart-temp', {
      type: 'line',
      data: {
        labels: [
          '01',
          '02',
          '03',
          '04',
          '05',
          '06',
          '08',
          '09',
          '10',
          '11',
          '12',
          '13',
          '14',
          '15',
          '16',
          '17',
          '18',
          '19',
          '20',
          '21',
          '22',
          '23',
          '00',
        ],

        datasets: [
          {
            label: 'Temp',
            data: [65, 59, 80, 81, 56, 55, 40],
            fill: false,
            borderColor: 'rgb(75, 16, 155)',
            tension: 0.1,
          },
        ],
      },
      options: {
        scales: {
          x: {
            ticks: {
              autoSkip: true,
              maxTicksLimit: 20,
            },
          },
        },
      },
    });
    const chartHumidity = new Chart('chart-humidity', {
      type: 'line',
      data: {
        labels: [
          '01',
          '02',
          '03',
          '04',
          '05',
          '06',
          '08',
          '09',
          '10',
          '11',
          '12',
          '13',
          '14',
          '15',
          '16',
          '17',
          '18',
          '19',
          '20',
          '21',
          '22',
          '23',
          '00',
        ],
        datasets: [
          {
            label: 'Humidity',
            data: [65, 59, 80, 81, 56, 55, 40],
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1,
          },
        ],
      },
      options: {
        scales: {
          x: {
            ticks: {
              autoSkip: true,
              maxTicksLimit: 10,
              stepSize: 2,
            },
          },
        },
      },
    });

    //get data evrey 10s
    const inter = interval(10000);
    const data = inter.subscribe(() => {});
  }
}
