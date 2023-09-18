import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GenerationTokenComponent } from './generation-token.component';
import { RouterModule, Routes } from '@angular/router';
import { NgCircleProgressModule } from 'ng-circle-progress';

const routes: Routes = [
	{ path: '', component: GenerationTokenComponent }

];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    NgCircleProgressModule.forRoot({
      "radius": 60,
      "space": -10,
      "outerStrokeGradient": true,
      "outerStrokeWidth": 10,
      "outerStrokeColor": "#ff0000",
      "outerStrokeGradientStopColor": "#f03d3d",
      "innerStrokeColor": "#e7e8ea",
      "innerStrokeWidth": 10,
      "titleFontSize": "45",
      "showSubtitle": false,
      "animateTitle": true,
      "animationDuration": 6000,
      "showUnits": false,
      "showBackground": false,
      "clockwise": false,
      "startFromZero": true,//permite refrescar 
      "lazy": true
    })
  ],
  exports: [RouterModule],
  declarations: [GenerationTokenComponent]
})
export class GenerationTokenModule { }
