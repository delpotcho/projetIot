import { Directive, ElementRef, Input, OnInit } from '@angular/core';
import { Environment, NodeData } from '../Service/environment.service';

@Directive({
  selector: '[TempColor]',
})
export class TempColorDirective implements OnInit {
  @Input('lastTemp') temp;
  @Input('env') env: Environment;

  constructor(public el: ElementRef) {}
  ngOnInit(): void {
    console.log(this.temp);

    console.log(this.env.minTemperature);
    if (
      this.temp < this.env.minTemperature ||
      this.temp > this.env.maxTemperature
    ) {
      this.el.nativeElement.style.color = 'red';
    }
  }
}
