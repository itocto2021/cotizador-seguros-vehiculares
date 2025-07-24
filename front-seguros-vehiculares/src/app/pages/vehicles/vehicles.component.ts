import { Component } from '@angular/core';

@Component({
  selector: 'app-vehicles.component',
  templateUrl: './vehicles.component.html',
  styleUrl: './vehicles.component.css',
  standalone: false
})
export class VehiclesComponent {
  vehicles = [
    {
      fotoUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI-GhZzzBS6GjF86JIjEHiyi3AkyiHkalrdqren76oWBrht4lOTtKycKC-PUBBVffpxeg&usqp=CAU',
      marca: 'Toyota',
      modelo: 'Corolla',
      precioDesde: 15000
    },
    {
      fotoUrl: 'https://hips.hearstapps.com/es.h-cdn.co/cades/contenidos/10806/hondasedancivic4.jpg',
      marca: 'Honda',
      modelo: 'Civic',
      precioDesde: 16000
    },
    {
      fotoUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOJeNDtHbQ1O6AeO9FNqCoFudmjZCYM8l5TA&s',
      marca: 'Ford',
      modelo: 'Focus',
      precioDesde: 14500
    },
    {
      fotoUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaHncR1W8bI1GchRrLWsGBf5xn-P0ZRgnc9A&s',
      marca: 'Mazda',
      modelo: '3',
      precioDesde: 15500
    },
    // agrega más si deseas
  ];
}
