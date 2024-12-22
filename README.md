# RestaurantApp

## Descripción del Proyecto
**RestaurantApp** es una aplicación desarrollada en Kotlin para dispositivos Android, diseñada para facilitar la toma de pedidos en un restaurante chileno. La aplicación permite al usuario (mesero) ingresar cantidades de platillos seleccionados, calcular subtotales automáticamente y gestionar totales con o sin propina.

## Características Principales
- **Platillos disponibles:**
  - Pastel de Choclo (12.000 CLP)
  - Cazuela (10.000 CLP)
- **Cálculo automático de subtotales** basado en la cantidad ingresada.
- **Opcionabilidad de propina (10%)** mediante un `Switch`.
- **Interfaz adaptable y ordenada** construida con `ConstraintLayout`.

## Tecnologías Utilizadas
- **Lenguaje de programación:** Kotlin
- **Entorno de desarrollo:** Android Studio
- **Diseño de la interfaz:** XML con `ConstraintLayout`

## Estructura del Proyecto
### Clases Modelo
1. **ItemMenu:** Representa los datos básicos de un platillo (nombre y precio).
2. **ItemMesa:** Representa un platillo seleccionado, incluyendo cantidad y cálculo del subtotal.
3. **CuentaMesa:** Administra los platillos seleccionados y calcula totales con y sin propina.

### Activity Principal
La `MainActivity` actúa como controlador principal, enlazando la interfaz de usuario con las clases modelo y gestionando eventos:
- Validación de cantidades.
- Actualización de subtotales y totales en tiempo real.
- Gestión del estado del `Switch` para la propina.

### Layout (XML)
El archivo `activity_main.xml` organiza:
- `ImageView` para mostrar las imágenes de los platillos.
- `TextView` para nombres, precios y subtotales.
- `EditText` para ingresar cantidades.
- `Switch` para activar o desactivar propina.

## Pantallas
1. **Pantalla Inicial:** Muestra los platillos disponibles con imágenes, nombres y precios.
2. **Cálculo de Subtotales:** Los subtotales se actualizan dinámicamente según las cantidades ingresadas.
3. **Activación de Propina:** Cambia los totales según el estado del `Switch` de propina.

## Instalación y Ejecución
1. Clona el repositorio:
   ```bash
   git clone https://github.com/Britoshky/RestaurantApp
   ```
2. Abre el proyecto en Android Studio.
3. Ejecuta el proyecto en un emulador o dispositivo Android (API mínima: 24).

## Autor
**[Héctor Brito Tapia]** - Estudiante de Ingeniería en Informática

## Licencia
Este proyecto está bajo la licencia MIT - consulta el archivo `LICENSE` para más detalles.

## Enlace al Proyecto
[Repositorio en GitHub](https://github.com/Britoshky/RestaurantApp)
