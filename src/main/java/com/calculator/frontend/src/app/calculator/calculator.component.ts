import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../calculator.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  salary: number;
  countries: string[] = ['United Kingdom', 'Germany', 'Poland'];
  currencyRates: [{
    name: string,
    rate: number
  }];

  calcForm = this.formBuilder.group({
    income: ['', [Validators.required, Validators.min(100)]],
    country: ['Poland']
  });

  constructor(private calculatorService: CalculatorService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculatorService.getAvailableCurrencies().subscribe(r => this.currencyRates = r);
  }

  getSalary() {
    const i = this.calcForm.get('income').value;
    const c = this.calcForm.get('country').value;
    this.calculatorService.getSalary(c, i).subscribe(s => this.salary = s);
  }

}
