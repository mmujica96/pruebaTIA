import { Component, OnInit } from '@angular/core';
import { TokenServiceService } from 'src/TokenService.service';

@Component({
  selector: 'app-historial',
  templateUrl: './historial.component.html',
  styleUrls: ['./historial.component.css']
})
export class HistorialComponent implements OnInit {
  public historial =[];

  constructor(private historialToken: TokenServiceService, private cliente: TokenServiceService) { 
    this.historialToken.obtenerHistorial("0912345671").subscribe((response) => {
      console.log('respuesta:', response.data);
      this.historial = response.data;
    })
  }

  ngOnInit(): void {
  }

  
}
