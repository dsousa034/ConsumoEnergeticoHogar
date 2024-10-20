# Consumo Energético Hogar Assil Asri, Daniel Sousa, Pablo Barbosa, Augusto Perrone

# Link al Repositorio: https://github.com/dsousa034/ConsumoEnergeticoHogar.git

## Descripción del Proyecto

El proyecto **Consumo Energético Hogar** es una aplicación móvil desarrollada en Kotlin utilizando Jetpack Compose para la interfaz de usuario. La aplicación permite a los usuarios monitorear y gestionar el consumo energético de su hogar, proporcionando visualizaciones y recomendaciones para optimizar el uso de energía.

## Características Principales

- **Monitoreo de Consumo**: La aplicación permite a los usuarios ver el consumo energético de diferentes categorías como calefacción y agua.
- **Visualización de Datos**: Utiliza gráficos de línea para mostrar el consumo energético de manera visual y comprensible.
- **Recomendaciones**: Proporciona mensajes personalizados basados en el consumo para ayudar a los usuarios a optimizar su uso de energía.
- **Navegación Intuitiva**: Implementa navegación entre diferentes pantallas utilizando Jetpack Navigation.

## Clases Principales

### `Calefacción`

- **Propósito**: Gestiona y muestra el consumo energético relacionado con la calefacción.
- **Componentes Clave**:
  - `consumoCalefaccion`: Variable que almacena el consumo de calefacción.
  - `CalefaccionScreen`: Composable que muestra la pantalla principal de consumo de calefacción, incluyendo un gráfico de línea y botones de navegación.
  - `LineChartView`: Composable que crea y muestra un gráfico de línea utilizando la biblioteca MPAndroidChart.

### `Agua`

- **Propósito**: Gestiona y muestra el consumo de agua.
- **Componentes Clave**:
  - `consumoAgua`: Variable que almacena el consumo de agua.
  - `mensaje`: Mensaje personalizado basado en el consumo de agua.
  - `AguaScreen`: Composable que muestra la pantalla principal de consumo de agua, incluyendo un gráfico de línea y un mensaje personalizado.
  - `LineChartView`: Composable que crea y muestra un gráfico de línea utilizando la biblioteca MPAndroidChart.

## Dependencias

El proyecto utiliza varias bibliotecas y plugins, incluyendo:

- **Jetpack Compose**: Para la creación de interfaces de usuario declarativas.
- **MPAndroidChart**: Para la visualización de datos en gráficos de línea.
- **Firebase**: Para la gestión de servicios en la nube.

## Configuración del Proyecto

Para configurar y ejecutar el proyecto, asegúrate de tener las siguientes dependencias en tu archivo `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))
    // Otras dependencias necesarias
}
