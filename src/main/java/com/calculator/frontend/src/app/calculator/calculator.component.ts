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
  countries: string[] = ['uk', 'de', 'pl'];

  calcForm = this.formBuilder.group({
    income: ['', [Validators.required, Validators.min(100)]],
    country: ['pl']
  });

  constructor(private calculatorService: CalculatorService, private formBuilder: FormBuilder) { }

  ngOnInit() {
  }

  getSalary() {
    const i = this.calcForm.get('income').value;
    const c = this.calcForm.get('country').value;
    this.calculatorService.getSalary(c, i).subscribe(s => this.salary = s);
  }

}
