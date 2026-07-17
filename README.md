# NexusPC

Sistema web de gestión de inventario y ventas desarrollado como proyecto universitario utilizando Java EE, JSP, Servlets, MVC y MySQL.

---

# Descripción

NexusPC permite administrar el inventario de una tienda de hardware, registrar clientes, realizar ventas, controlar el stock de productos y generar reportes para facilitar la gestión del negocio.

---

# Funcionalidades

- Inicio de sesión con autenticación.
- Gestión de productos.
- Gestión de clientes.
- Gestión de usuarios.
- Registro de ventas.
- Historial de ventas.
- Búsqueda de ventas por fecha.
- Generación de boletas en PDF.
- Control de stock.
- Alerta por stock insuficiente.
- Reportes del sistema.

---

# Tecnologías utilizadas

- Java 21
- JSP
- Servlets
- Arquitectura MVC
- Patrón DAO
- MySQL
- Apache Tomcat 11
- Maven
- Bootstrap 5
- JWT
- BCrypt
- OpenPDF

---

# Arquitectura

El proyecto está organizado siguiendo el patrón MVC.

```
src
│
├── controller
├── model
├── dao
│   ├── impl
│   └── interfaces
├── service
├── util
└── webapp
    ├── views
    ├── layouts
    ├── components
    └── assets
```

---

# Requisitos

- Java JDK 21
- Apache Tomcat 11
- Maven
- MySQL
- XAMPP (opcional)

---

# Instalación

## 1. Clonar el proyecto

```bash
git clone https://github.com/Jkeyleb/NexusPC.git
```

## 2. Crear la base de datos

Crear una base de datos llamada:

```
nexuspc
```

Importar el script SQL incluido en el proyecto.

---

## 3. Configurar la conexión

Editar la clase:

```
DBConnection.java
```

y configurar:

- Host
- Puerto
- Usuario
- Contraseña

---

## 4. Compilar

```bash
mvn clean install
```

---

## 5. Ejecutar

Desplegar el archivo:

```
nexuspc.war
```

en Apache Tomcat.

---

# Credenciales de prueba

Administrador

```
Usuario:
admin

Contraseña:
admin123
```

> Cambiar las credenciales según los datos registrados en la base de datos.

---

# Roles

El sistema cuenta con tres tipos de usuarios.

- Administrador
- Vendedor
- Almacén

Cada rol posee permisos diferentes dentro del sistema.

---

# Características

- Autenticación mediante JWT.
- Contraseñas cifradas con BCrypt.
- Validación de stock antes de registrar una venta.
- Generación de boletas en PDF.
- Interfaz desarrollada con Bootstrap.
- Diseño basado en componentes reutilizables.

---

# Capturas

Se recomienda agregar imágenes de:

- Login
- Dashboard
- Inventario
- Clientes
- Ventas
- Reportes

---

# Autor

Caleb Silva

Proyecto desarrollado para el curso de Desarrollo de Aplicaciones Web.