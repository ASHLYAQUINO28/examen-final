Repaso Examen Final – Desarrollo de APIs REST

## Descripción
Este proyecto consiste en el desarrollo de tres APIs REST utilizando Java y Spring Boot. Cada ejercicio implementa operaciones para administrar información mediante una estructura por capas, almacenamiento en memoria y validaciones de datos.

## Ejercicios desarrollados

### Ejercicio 1: API de Profesores
Permite administrar la información de profesores.

**Atributos:**
- ID
- Nombre
- Apellido
- Correo electrónico
- Especialidad
- Estado

**Endpoints:**
| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/profesores` | Crear profesor |
| GET | `/api/profesores` | Listar profesores |
| GET | `/api/profesores?especialidad=Matematicas` | Filtrar por especialidad |
| GET | `/api/profesores/{id}` | Consultar por ID |

### Ejercicio 2: API de Proveedores
Permite administrar la información de proveedores.

**Atributos:**
- ID
- Nombre
- Apellido
- Correo electrónico
- Categoría
- Estado

**Endpoints:**
| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/proveedores` | Crear proveedor |
| GET | `/api/proveedores` | Listar proveedores |
| GET | `/api/proveedores?categoria=Tecnologia` | Filtrar por categoría |
| GET | `/api/proveedores/{id}` | Consultar por ID |

### Ejercicio 3: API de Empleados
Permite administrar la información de empleados.

**Atributos:**
- ID
- Nombre
- Apellido
- Correo electrónico
- Especialidad
- Estado

**Endpoints:**
| Método | Endpoint | Descripción |
|---|---|---|
| POST | `/api/empleados` | Crear empleado |
| GET | `/api/empleados` | Listar empleados |
| GET | `/api/empleados?especialidad=Desarrollo` | Filtrar por especialidad |
| GET | `/api/empleados/{id}` | Consultar por ID |

## Características implementadas

- Desarrollo utilizando Java y Spring Boot.
- Arquitectura organizada por capas: Model, Repository, Service y Controller.
- Almacenamiento de información mediante listas en memoria.
- Operaciones para crear, consultar, listar y filtrar registros.
- Validación de campos obligatorios.
- Validación del formato del correo electrónico.
- Manejo de excepciones para registros inexistentes.
- Implementación de códigos de respuesta HTTP.
- Protección de los endpoints mediante autenticación con API Key.

## Seguridad

Se implementó la validación de API Key mediante el encabezado HTTP:

`X-API-KEY: 123456`

Las peticiones que no proporcionan una clave válida reciben una respuesta `401 Unauthorized`.

## Pruebas realizadas

Se realizaron pruebas utilizando Postman para verificar el funcionamiento de los tres ejercicios.

Se comprobaron los siguientes escenarios:

- Creación de registros: `201 Created`.
- Consulta de registros: `200 OK`.
- Filtrado por especialidad o categoría: `200 OK`.
- Consulta por identificador: `200 OK`.
- Consulta de registros inexistentes: `404 Not Found`.
- Validación de datos incorrectos: `400 Bad Request`.
- Validación de API Key incorrecta o ausente: `401 Unauthorized`.

### Pruebas unitarias

Se implementaron y ejecutaron exitosamente las pruebas unitarias para verificar las operaciones principales de los servicios, incluyendo:

- Creación de registros.
- Consulta de registros existentes.
- Manejo de registros inexistentes.

Las pruebas finalizaron exitosamente, comprobando el comportamiento esperado de las funcionalidades desarrolladas.

## Tecnologías y herramientas

- Java
- Spring Boot
- Maven
- Postman
- Visual Studio Code
- Git y GitHub

## Autor
Ashly Aquino
