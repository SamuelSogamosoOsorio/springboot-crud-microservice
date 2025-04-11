# 📦 Spring Boot CRUD Microservice

Este proyecto es un microservicio RESTful desarrollado con **Spring Boot** que permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una entidad `Product`. El servicio está conectado a una base de datos **MariaDB**, está completamente contenerizado con **Docker** y **Docker Compose**, y cuenta con **pruebas unitarias** automatizadas y **reporte de cobertura con JaCoCo**.

---

## 🧠 Tecnologías y herramientas utilizadas

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- MariaDB
- Maven
- JUnit 5 + Mockito
- JaCoCo
- Docker & Docker Compose
- Thunder Client (para pruebas manuales)

---

## 🚀 ¿Cómo ejecutar el proyecto con Docker?

### 1. Clona el repositorio
```bash
git clone https://github.com/tu-usuario/springboot-crud-microservice.git
cd springboot-crud-microservice
```

### 2. Ejecuta el script automático
```bash
./build-run.sh
```
Esto limpiará contenedores antiguos, reconstruirá la imagen y levantará los servicios:
- `springboot-app` en el puerto `8081`
- `mariadb` en el puerto `3306`

### 3. Probar el API
Puedes usar **Thunder Client** o herramientas como `curl` o `wget`:
```bash
GET http://localhost:8081/products
```

---

## 🧪 Ejecutar pruebas unitarias y generar cobertura

### 1. Ejecutar pruebas:
```bash
./mvnw clean verify
```

### 2. Ver reporte de cobertura (JaCoCo):
```bash
xdg-open target/site/jacoco/index.html
```

> También se ha exportado una copia en `docs/cobertura/index.html`

---

## 🧪 Endpoints disponibles

| Método | Endpoint         | Descripción         |
|--------|------------------|---------------------|
| GET    | /products        | Listar productos    |
| GET    | /products/{id}   | Obtener por ID      |
| POST   | /products        | Crear producto      |
| PUT    | /products/{id}   | Actualizar producto |
| DELETE | /products/{id}   | Eliminar producto   |

---

## 🧪 Cobertura de código (JaCoCo)

- `ProductController`: ✅ 100%
- `ProductService`: ✅ Cobertura completa con pruebas unitarias
- `Product`: Cobertura parcial (constructores y getters/setters)

Imagen del reporte:
![Cobertura](docs/cobertura/index.html)

---

## 🧼 Scripts útiles

### 🛠 `build-run.sh`
Automatiza el despliegue completo:
```bash
./build-run.sh
```

### 💾 `backup.sh`
Realiza un respaldo de la base de datos:
```bash
./backup.sh
```

---

## 🌐 Imagen en Docker Hub

🛳️ Puedes obtener la imagen directamente desde Docker Hub:
```bash
docker pull tuusuario/crudmicro:v1
```
📦 Imagen disponible en: [https://hub.docker.com/r/tuusuario/crudmicro](https://hub.docker.com/r/tuusuario/crudmicro)

---

## 🔌 Thunder Client

Se incluye una colección lista para importar en `docs/thunder-crud-productos.json`

---

## 💡 Autor
Samuel Sogamoso Osorio

Proyecto desarrollado como parte del **Parcial 2 - Cloud Native** 🧠💻

---

## ✅ Estado actual

- [x] CRUD funcional
- [x] Docker y Docker Compose
- [x] Base de datos persistente
- [x] Pruebas unitarias (controller + service)
- [x] Cobertura con JaCoCo
- [x] Documentación y colección Thunder
- [x] Imagen publicada en Docker Hub
- [x] Script de automatización (`build-run.sh`)

---

> ¡Entrega lista para brillar! 🎓🔥

