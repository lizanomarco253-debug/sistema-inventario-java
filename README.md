# 📦 Sistema de Inventario - Java

Sistema de gestión de inventario para pequeños negocios (bodegas, minimarkets), desarrollado en Java aplicando Programación Orientada a Objetos, con persistencia de datos en archivo.

Este proyecto fue construido como parte de mi ruta de aprendizaje hacia el desarrollo Full Stack, con foco en fundamentos sólidos de backend antes de avanzar hacia tecnologías web.

## 🎯 Funcionalidades

- ✅ Registrar productos con validación de datos (precio y stock no negativos, código único)
- 🔍 Buscar productos por código
- ✏️ Actualizar stock de un producto existente
- 🗑️ Eliminar productos
- 📋 Listar todos los productos registrados
- 💰 Ordenar productos por precio (algoritmo Bubble Sort implementado desde cero)
- ⚠️ Alertar productos con stock bajo (menos de 5 unidades)
- 💾 Persistencia de datos en archivo de texto (los datos no se pierden al cerrar el programa)

## 🛠️ Tecnologías

- Java 21
- Programación Orientada a Objetos (encapsulamiento, validaciones en constructor y setters)
- Manejo de excepciones (`IllegalArgumentException`, `IOException`)
- Colecciones (`ArrayList`)
- Lectura y escritura de archivos (`FileWriter`, `BufferedReader`)
- Git y GitHub para control de versiones

## 🏗️ Arquitectura

El proyecto está organizado en tres capas, separando responsabilidades:
src/
├── modelo/
│ └── Producto.java → Entidad con atributos, validaciones y comportamiento propio
├── servicio/
│ └── Inventario.java → Lógica de negocio: CRUD, búsqueda, ordenamiento, persistencia
└── app/
└── Main.java → Interfaz de consola y punto de entrada

**Por qué esta estructura:** la clase `Main` nunca manipula la lista de productos directamente — solo le pide cosas a `Inventario`, que a su vez nunca accede a los atributos privados de `Producto` sin pasar por sus métodos públicos. Esta separación de responsabilidades es la misma idea detrás de arquitecturas más avanzadas como Controller-Service-Repository, que planeo aplicar en mi próximo proyecto con Spring Boot.

## 🚀 Cómo ejecutarlo

1. Clonar el repositorio:
git clone https://github.com/lizanomarco253-debug/sistema-inventario-java.git
2. Abrir la carpeta en VS Code o NetBeans
3. Ejecutar la clase `Main.java`
4. Los datos se guardan automáticamente en `productos.txt` en la raíz del proyecto

## 💡 Lo que aprendí construyendo esto

- Diseñar un modelo de clases antes de escribir código, pensando en relaciones y responsabilidades
- Aplicar Bubble Sort sobre objetos personalizados, no solo sobre números sueltos
- Depurar un bug lógico silencioso (sin errores de compilación): una llamada faltante en el constructor que impedía cargar los datos guardados, encontrado agregando trazas de diagnóstico y revisando el flujo completo del código
- Flujo completo de Git: desde `git init` hasta resolver un repositorio mal configurado inicialmente

## 📌 Próximas mejoras

- [ ] Interfaz gráfica o migración a aplicación web (Full Stack)
- [ ] Persistencia en base de datos relacional
- [ ] Pruebas unitarias con JUnit

## 👤 Autor

Marco Lizano
Estudiante de Ingeniería de Sistemas
[LinkedIn](www.linkedin.com/in/marcoalizano) · [GitHub](https://github.com/lizanomarco253-debug)