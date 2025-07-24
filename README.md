# 🚗 Cotizador Seguros Vehiculares - Frontend Angular

Este proyecto es el frontend del sistema de cotización de seguros vehiculares. Está desarrollado con **Angular 20+**, **Angular Material** y **Angular Icons**, y se conecta a un backend RESTful para obtener modelos de vehículos y calcular cotizaciones.

---

## ✨ Características Principales

- ✅ Navbar superior con íconos y botones (`Angular Material`)
- ✅ Sidebar lateral derecho con menú desplegable
- ✅ Consulta dinámica de vehículos desde el backend
- ✅ Envío de datos para cotización y visualización del resultado
- ✅ Interfaz moderna y responsiva con Angular Material
- ✅ Soporte para **Docker** y **Docker Compose**

---

## 🧩 Tecnologías Utilizadas

| Categoría         | Tecnologías                                        |
|-------------------|---------------------------------------------------|
| Frontend          | Angular 20+, Angular Material, Angular Icons      |
| Estilos           | Bootstrap, SCSS, CSS                              |
| Backend           | Java 17, Spring Boot 3.2, WebFlux                 |
| Persistencia      | PostgreSQL, Redis                                 |
| DevOps            | Docker, Docker Compose                            |

---

## 🔧 Instalación y Ejecución Local

### Requisitos previos

- Node.js y Angular CLI instalados
- PostgreSQL y Redis en ejecución local

### Pasos

```bash
# Clonar el repositorio
git clone https://github.com/itocto2021/cotizador-seguros-vehiculares.git

# Ingresar al frontend
cd cotizador-seguros-vehiculares/front-seguros-vehiculares

# Instalar dependencias
npm install

# Ejecutar servidor de desarrollo
ng serve -o
```
### 📁 Estructura del Proyecto (Frontend)
```bash
src/
├── app/
│   ├── _components/
│   ├── dashboards/
│   ├── home/
│   ├── layout/
│   ├── main/
│   ├── pages/
│   ├── services/
│   ├── app.component.ts / .html / .scss
│   ├── app.module.ts
│   └── app.routing.module.ts
├── assets/
├── environments/
├── index.html
├── main.ts
```
## 🐳 Dockerización y Despliegue
- Requisitos
- Tener instalado Docker Desktop: https://www.docker.com/products/docker-desktop/

Ejecutar toda la solución
Desde la raíz del proyecto (donde está el archivo docker-compose.yml):
---
```bash
# Ingresar al backend
cd cotizador-seguros-vehiculares

# Abrir terminal y ejecutar Docker Compose
docker-compose up --build
```
### Servicios Disponibles

| Servicio     | URL / Puerto             |
|--------------|---------------------------|
| Frontend     | [http://localhost:4200](http://localhost:4200) |
| Backend      | [http://localhost:8080](http://localhost:8080) |
| Redis        | Puerto `6379`            |
| PostgreSQL   | Puerto `5432`            |

---

### Endpoints del Backend

### 1. Obtener lista de vehículos
**Método:** `GET`  
**URL:** `http://localhost:8080/api/v1/vehicles`

#### 📥 Respuesta ejemplo:
```json
[
  { "id": 1, "brand": "Toyota", "model": "Corolla", "year": 2020 },
  { "id": 2, "brand": "Honda", "model": "Civic", "year": 2019 }
]
```

### 2. Solicitar cotización  
**Método:** `POST`  
**URL:** `http://localhost:8080/api/v1/quotes`

#### 📤 Body de solicitud:
```json
{
  "brand": "Toyota",
  "model": "Corolla",
  "year": 2015,
  "usageType": "Personal",
  "driverAge": 25
}
```
### 📥 Respuesta ejemplo:
```json
{
  "basePrice": 500.0,
  "adjustments": [
    "+10% por uso \"carga\""
  ],
  "totalPremium": 550.0
}

```
