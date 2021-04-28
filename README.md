# sofca-arbol-binario-Back

# Configuración

Para configurar adecuadamente el proyecto verificar el archivo:

/arbolBinBack/src/main/resources/application.properties

El proyecto corre en el puerto server.port:8044 y el proyecto front usa http://localhost:8044/api/ para accedeer a los servicios.

# Cross-Origin

Cross-Origin esta configurado para recibir peticiones desde http://localhost:4200

# Base de datos Mysql

Antes de ejecutar el proyecto es necesario crear una base de datos mysql llamada "db_rest_service"

Es necesario establecer usario y contraseña en:

/arbolBinBack/src/main/resources/application.properties

spring.datasource.username=

spring.datasource.password=

# Maven

Puede usar el comando mvn install despues de clonar el proyecto desde el repositorio o importar como proyecto maven desde eclipse IDE
