# Sistema de Inventario - Java

Sistema de gestión de inventario para pequeños negocios (bodegas, minimarkets), desarrollado en consola con Java aplicando Programación Orientada a Objetos.

## Funcionalidades

- Registrar productos con validación de datos (precio, stock, código único)
- Buscar productos por código
- Actualizar stock
- Eliminar productos
- Listar todos los productos
- Ordenar productos por precio (algoritmo Bubble Sort)
- Alertar productos con stock bajo

## Tecnologías

- Java 17
- Programación Orientada a Objetos (encapsulamiento, validaciones)
- Manejo de excepciones
- Colecciones (ArrayList)

## Arquitectura

El proyecto está organizado en tres capas:

- `modelo`: contiene la clase `Producto`, con sus atributos y validaciones
- `servicio`: contiene la clase `Inventario`, con la lógica de negocio (CRUD, búsqueda, ordenamiento)
- `app`: contiene la clase `Main`, con el menú interactivo de consola

## Cómo ejecutarlo

1. Clonar el repositorio
2. Abrir la carpeta en VS Code o NetBeans
3. Ejecutar la clase `Main.java`

## Próximas mejoras

- Persistencia de datos en archivo
- Interfaz gráfica o web