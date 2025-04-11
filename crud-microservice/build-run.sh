#!/bin/bash

echo "🧼 Limpiando contenedores anteriores..."
docker compose down -v --remove-orphans

echo "🔨 Construyendo imagen de la aplicación..."
docker compose build

echo "🚀 Levantando los contenedores..."
docker compose up -d

echo "✅ Todo listo. Servicios activos:"
docker ps
