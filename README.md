# Prueba Técnica Spring Boot

### Estructura del Proyecto:

El proyecto está estructurado en paquetes de acuerdo a la arquitectura hexagonal, con la siguiente estructura:

1. **Application:** Contiene los casos de uso del dominio.
    - [Price Use Cases](/src/main/java/gft/techtest/application/PriceUseCases.java)
2. **Domain:** Contiene el dominio de la aplicación, la entidad base, la excepción de no encontrado y el 
    puerto a implementar por la infraestructura.
    - [Price](/src/main/java/gft/techtest/domain/entity/Price.java)
    - [NotFoundException](/src/main/java/gft/techtest/domain/exception/NotFoundException.java)
    - [PriceService](/src/main/java/gft/techtest/domain/port/PriceService.java)
3. **Infraestructure:** Contiene la implementación de los puertos del dominio (en este caso el servicio al repositorio),
    y el controlador REST. Todo lo relacionado con la infraestructura de la aplicación.
    - [PriceServiceImpl](/src/main/java/gft/techtest/infrastructure/outbound/database/PriceServiceImpl.java)
    - [PriceRepository](/src/main/java/gft/techtest/infrastructure/outbound/database/PriceRepository.java)
    - [PriceController](/src/main/java/gft/techtest/infrastructure/inbound/rest/PriceController.java)
    - [MyExceptionHandler](/src/main/java/gft/techtest/infrastructure/inbound/rest/MyExceptionHandler.java)

Para desarrollar el endpoint pedido se ha realizado usando TDD de la siguiente forma:

1. **Creación de un test e2e para el endpoint de consulta de precios:**
    - Se ha creado un test de integración para el endpoint que verifica lo que se pide en el enunciado. Este test
   engloba las 5 llamadas pedidas en el enunciado y verifica lo que se espera.
    - [Test de Integración](/src/test/java/gft/techtest/integration/E2EIntegrationTest.java)

2. **Iteración de test unitarios:**
    - Luego, para implementar el endpoint, se han creado test unitarios desde el repositorio hasta el controlador,
   primero haciendo los test, luego implementando el código y finalmente refactorizando.
    - [Test de Repositorio](/src/test/java/gft/techtest/infrastructure/outbound/database/PriceRepositoryTest.java)
    - [Test de Servicio](/src/test/java/gft/techtest/infrastructure/outbound/database/PriceServiceImplTest.java)
    - [Test de Controlador](/src/test/java/gft/techtest/infrastructure/inbound/rest/PriceControllerTest.java)
3. **Analisis de calidad:**
    - Tras tener todo implementado se ha utilizado Sonnar para verificar la calidad del código.


## Cosas que se podrían mejorar o implementar:

Anoto por aquí cosas rapidas que se podrian añadir a mi aplicación para mejorarla:

- Implementar un productor de eventos para notificar a otros sistemas cuando se actualiza un precio.
- Implementar un sistema de caché para los precios.
- Implementar un servicio de autenticación y autorización más robusto con JWT.
- Automatizar CI/CD con GitHub Actions.
- Implementar verificacion con SonarQube automatica.
