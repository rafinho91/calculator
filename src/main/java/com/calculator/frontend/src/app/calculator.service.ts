import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor(private http: HttpClient) { }

  getSalary(country: string, dailyIncome: number): Observable<any> {
    return this.http.get('//localhost:8080/calc/' + country + '?dailyIncome=' + dailyIncome);
  }

  getAvailableCurrencies(): Observable<any> {
    return this.http.get('//localhost:8080/calc/currencies');
  }
}
