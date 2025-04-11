# 📋 Instrucciones para Evaluación Automática del Proyecto

Este proyecto incluye un script de evaluación automática para facilitar la revisión del microservicio CRUD desarrollado en Spring Boot. A continuación se describen los pasos para ejecutar el script `grade.sh` y validar el cumplimiento de los requerimientos del parcial.

---

## ⚙️ Requisitos previos

- Tener instalado Docker y Docker Compose.
- Tener acceso a un entorno Unix/Linux (idealmente Debian, Ubuntu o WSL).
- Puerto 8081 disponible en el sistema.

---

## 🚀 Pasos para ejecutar la evaluación

### 1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/springboot-crud-microservice.git
cd springboot-crud-microservice
```

### 2. Dar permisos de ejecución al script
```bash
chmod +x grade.sh
```

### 3. Levantar los servicios necesarios
```bash
docker compose up -d
```

> Esperar unos segundos para que la base de datos y la app estén listos.

### 4. Ejecutar el script de evaluación
```bash
./grade.sh
```

Este script:
- Verifica que los contenedores estén funcionando
- Realiza pruebas básicas a los endpoints CRUD (`POST`, `GET`, `PUT`, `DELETE`)
- Revisa que el reporte de cobertura con JaCoCo exista
- Genera un archivo `resultado.txt` con los resultados de todas las pruebas

---

## 📂 Archivos generados

- `resultado.txt`: Registro de todas las validaciones realizadas por el script.
- `target/site/jacoco/index.html`: Reporte de cobertura generado con JaCoCo (previamente generado con `mvnw clean verify`).

---

## 💡 Nota adicional

Este proyecto también incluye:
- Script de respaldo de la base de datos (`backup.sh`)
- Script de automatización de despliegue (`build-run.sh`)
- Colección Thunder Client para pruebas manuales (`docs/thunder-crud-productos.json`)

---

## ✅ Evaluación rápida

Para facilitar aún más, los pasos mínimos para revisar:
```bash
docker compose up -d
./grade.sh
cat resultado.txt
xdg-open target/site/jacoco/index.html
```

---

🎓 ¡Gracias por revisar este trabajo!
Desarrollado con 💻 por Samuel Tinguistinguis para el Parcial 2 de Sistemas Operativos.

