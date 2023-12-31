---

# Cliente Info Service

Cliente Info Service es una aplicación Spring Boot diseñada para proveer información sobre clientes basándose en su tipo y número de documento.

## Requisitos

- Java 17

## Ejecución del Proyecto

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/WillDevp/ClienteInfoService
   cd ClienteInfoService
   ```

2. **Compilar y Ejecutar con Maven**:
   ```bash
   mvn spring-boot:run
   ```

La aplicación ahora debería estar ejecutándose en `http://localhost:8090`.

## Endpoints

1. **Obtener información del cliente**:
    - **URL**: `/cliente`
    - **Método**: `GET`
    - **Parámetros de Consulta**:
        - `tipo`: Tipo de documento (por ejemplo, "C" o "P").
        - `numero`: Número del documento.
    - **Ejemplo de Uso**:
      ```
      http://localhost:8080/cliente?tipoId=C&numeroId=23445322
      ```

## Generar y Ejecutar el JAR

1. **Compilar y Empaquetar**:
   ```bash
   mvn clean package
   ```

2. **Ejecutar el JAR**:
   ```bash
   java -jar target/cliente-info-service-0.0.1-SNAPSHOT.jar
   ```

---
