import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

interface Vehicle {
  id: number;
  brand: string;
  model: string;
  year: number;
}

interface QuoteResponse {
  basePrice: number;
  adjustments: string[];
  totalPremium: number;
}

@Component({
  selector: 'app-insurance-form',
  templateUrl: './insurance-form.component.html',
  styleUrls: ['./insurance-form.component.css'],
  standalone: false
})
export class InsuranceFormComponent implements OnInit {
  insuranceForm!: FormGroup;
  vehicles: Vehicle[] = [];
  brands: string[] = [];
  filteredModels: string[] = [];
  quoteResult?: QuoteResponse;

  constructor(private fb: FormBuilder, private http: HttpClient) {}

  ngOnInit() {
    this.insuranceForm = this.fb.group({
      brand: ['', Validators.required],
      model: ['', Validators.required],
      usageType: ['', Validators.required],
      year: ['', Validators.required],
      driverAge: ['', Validators.required]
    });

    this.loadVehicles();
  }

  loadVehicles() {
    this.http.get<Vehicle[]>('http://localhost:8080/api/v1/vehicles')
      .subscribe(data => {
        this.vehicles = data;
        console.log('Vehicles loaded:', this.vehicles);
        this.brands = [...new Set(data.map(v => v.brand))];
      });
  }

  onBrandChange(selectedBrand: string) {
    this.filteredModels = this.vehicles
      .filter(v => v.brand === selectedBrand)
      .map(v => v.model);
    this.insuranceForm.get('model')?.reset();
  }

  onSubmit() {
    if (this.insuranceForm.valid) {
      const payload = this.insuranceForm.value;
      this.http.post<QuoteResponse>('http://localhost:8080/api/v1/quotes', payload)
        .subscribe(response => {
          this.quoteResult = response;
        });
    }
  }

  resetForm() {
    this.insuranceForm.reset();
    this.filteredModels = [];
    this.quoteResult = undefined;
  }

}
