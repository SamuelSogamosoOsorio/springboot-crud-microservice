#!/bin/bash

# Fecha actual
DATE=$(date +%F)

# Ruta de destino
DEST="./docker/mariadb/backup_$DATE.sql"

# Ejecutar mysqldump desde el contenedor
docker exec mariadb sh -c 'exec mysqldump -uroot -p1234 mydb' > "$DEST"

echo "✅ Backup creado en $DEST"
