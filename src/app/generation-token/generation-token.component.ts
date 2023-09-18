import { Component, OnInit } from '@angular/core';
import { TokenServiceService } from 'src/TokenService.service';

@Component({
  selector: 'app-generation-token',
  templateUrl: './generation-token.component.html',
  styleUrls: ['./generation-token.component.css']
})
export class GenerationTokenComponent implements OnInit {

  public token: string = '';
  public seconds: number = 6000;

  constructor(private tokenServiceService: TokenServiceService) {
    this.tokenServiceService.obtenerToken("0940715428").subscribe((response) => {
      console.log('respuesta de la api');
      console.log(response.data);
      let createdate = new Date(response.data.createdate);
      let expireddate = new Date(response.data.expireddate);
      console.log(createdate, expireddate);
      this.seconds = (expireddate.getTime() - createdate.getTime());
      console.log(this.seconds)
      response.data.createdate
      response.data.expireddate
      this.token = response.data.otpToken;
      setTimeout(() => {
        this.getToken();
      }, this.seconds);
    })
   }

  ngOnInit(): void {
    
  }

  getToken(){
    this.tokenServiceService.obtenerToken("0912345671").subscribe((response) => {
      console.log('respuesta de la api');
      console.log(response.data);
      let createdate = new Date(response.data.createdate);
      let expireddate = new Date(response.data.expireddate);
      console.log(createdate, expireddate);
      this.seconds = (expireddate.getTime() - createdate.getTime());
      console.log(this.seconds)
      response.data.createdate
      response.data.expireddate
      this.token = response.data.otpToken;
      
      setTimeout(() => {
        this.getToken();
      }, this.seconds);
    })
  }

}

