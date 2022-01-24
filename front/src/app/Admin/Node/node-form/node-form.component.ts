import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Environment } from '../../Environment/Service/environment.service';
import { NodeServiceService } from '../Service/node-service.service';

@Component({
  selector: 'app-node-form',
  templateUrl: './node-form.component.html',
  styleUrls: ['./node-form.component.css'],
})
export class NodeFormComponent implements OnInit {
  @Input() environmentId: string;
  nodeGroup: FormGroup;
  constructor(
    private router: Router,
    private nodeService: NodeServiceService
  ) {}

  ngOnInit(): void {
    this.nodeGroup = new FormGroup({
      environmentId: new FormControl(this.environmentId),
      name: new FormControl(null),
    });
  }

  onSubmit() {
    console.log(this.nodeGroup.value);

    this.nodeService.newNode(this.nodeGroup.value).subscribe(
      (data) => {
        console.log(data);
        this.router
          .navigateByUrl(this.router.url, { skipLocationChange: false })
          .then(() => {
            this.router
              .navigate([this.router.url])
              .then(() => window.location.reload());
          });
      },
      (err) => console.log(err)
    );
  }
}
