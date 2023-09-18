import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {
  private URI = 'http://localhost:8080/api'
  constructor(private http: HttpClient){}

  obtenerCliente(): Observable<any>{
    return this.http.get(`${this.URI}/users`);
  }
  ingresarCliente(datos: any): Observable<any>{
    return this.http.post<any>(this.URI+"/users",datos)
  }

  obtenerToken(identification: string): Observable<any>{
    return this.http.get(`${this.URI}/tokens/${identification}`);
  }

  obtenerHistorial(identification: string): Observable<any>{
    return this.http.get(`${this.URI}/token-history/${identification}`);
  }

}
