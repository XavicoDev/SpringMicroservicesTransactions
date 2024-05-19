# Micorservicios para el manejo de retiros y depositos

Este proyecto es una aplicación de microservicios desarrollada en Spring Boot. Utiliza PostgreSQL como base de datos y está construida con la versión 3.2.5 del spring-boot-starter-parent.

## Módulos

El proyecto está dividido en varios módulos:

- **micorservice-customer:** (Cliente, Persona): Este módulo se encarga de gestionar la información relacionada con los clientes y las personas.
- **micorservice-account:** (Cuenta, Movimientos): El módulo de cuenta gestiona la información relacionada con las cuentas bancarias y sus movimientos.
- **microservice-config:** Este módulo proporciona la configuración centralizada para los demás microservicios.
- **microservice-eureka:** Es el servicio de registro y descubrimiento basado en Eureka.
- **microservice-gateway:** Actúa como una puerta de enlace para todos los servicios y enruta las solicitudes a los microservicios correspondientes.

## Características destacadas

- **PostgreSQL:** Se utiliza PostgreSQL como base de datos para almacenar los datos del sistema.
- **Versionamiento de Spring Boot:** La aplicación está construida con la versión 3.2.5 del spring-boot-starter-parent.
- **Proyecciones:** Se implementan proyecciones para consultar y manipular datos de manera eficiente.
- **Código reutilizable:** El proyecto promueve la reutilización de código mediante la definición de interfaces estándar de CRUD para los repositorios, servicios y controladores.
- **Prueba unitaria:** Usando Mockito, se generó una prueba unitaria para el `microservice-account`. La prueba se encuentra en `AccountServiceTest` y está diseñada para el servicio findAllByCustomerId. Este es un ejemplo de cómo se pueden implementar pruebas unitarias en todos los servicios.

## ¿ Cómo empezar ?

1. Clona el repositorio:
```
git clone https://github.com/XavicoDev/SpringMicroservicesTransactions.git
```
2. Crear las base de datos customerDB y accountDB en PostgreSQL 
2. Configure la conexión a PostgreSQL en los archivos `ms-account.yml` y `ms-customer.yml` de cada microservicio. Puede encontrar estas configuraciones en el subdirectorio `resources` del microservicio `microservice-config`.
3. Ejecuta cada microservicio individualmente, se recomienda el siguienrte orden:
- microservice-config
- microservice-eureka
- micorservice-customer
- micorservice-account
- microservice-gateway

## Pruebas con Postman

Para facilitar las pruebas de las APIs de los microservicios, se incluye una colección de Postman en el archivo Transactions.postman_collection.json, que contiene las principales APIs del proyecto.

### Instrucciones para Importar la Colección en Postman

1. Abre Postman.
2. Haz clic en el botón Importar.
3. Selecciona el archivo Transactions.postman_collection.json del directorio del proyecto o [descárgalo aquí](Transactions.postman_collection.json).
4. Una vez importada, verás una colección llamada Transactions con las principales APIs listas para ser probadas.