# Ejercicio de Programación Funcional en Kotlin

Este ejercicio está dividido en **dos partes** y tiene como objetivo profundizar en conceptos avanzados de programación funcional utilizando Kotlin. Implementarás funciones de colección y funciones de orden superior, además de escribir pruebas unitarias para garantizar su correcto funcionamiento.

## Descripción del Ejercicio

### **Parte 1: Funciones de Colección**

Implementarás las siguientes funciones de colección, replicando el comportamiento de las funciones estándar de Kotlin:

- **customForEach**: Itera sobre una colección aplicando una acción a cada elemento.
- **customMap**: Transforma cada elemento de una colección y devuelve una nueva colección con los resultados. Deberá usar `customForEach` internamente.
- **customFilter**: Filtra elementos de una colección basándose en un predicado. Deberá usar `customForEach` internamente.
- **customFold**: Acumula un valor inicial con cada elemento de la colección mediante una operación.
- **customReduce**: Reduce la colección a un único valor acumulando los elementos mediante una operación.
- **customPartition**: Divide la colección en dos listas basándose en un predicado.
- **customAll**: Verifica si todos los elementos cumplen con un predicado.
- **customAny**: Verifica si al menos un elemento cumple con un predicado. (Opcional: implementar usando `customAll`).

### **Parte 2: Funciones Funcionales**

Implementarás las siguientes funciones de orden superior y combinadores:

- **once**: Asegura que una función dada solo pueda ser llamada una vez.
- **memoize**: Almacena en caché los resultados de las llamadas a funciones para optimizar el rendimiento.
- **currying**: Transforma una función que toma múltiples argumentos en una secuencia de funciones, cada una tomando un solo argumento.
- **andThen** (Combinador Personalizado): Compone dos funciones donde la salida de la primera función se convierte en la entrada de la segunda.

## Objetivos de Aprendizaje

- Comprender y aplicar conceptos avanzados de programación funcional.
- Practicar la implementación de funciones de colección y de orden superior.
- Escribir pruebas unitarias completas que incluyan casos borde.
- Familiarizarse con flujos de trabajo colaborativos utilizando Git y GitHub.

## Instrucciones para Comenzar

### 1. Realiza un Fork del Repositorio

- Haz clic en el botón **"Fork"** en la esquina superior derecha del repositorio para crear una copia en tu cuenta de GitHub.

### 2. Clona tu Repositorio Forkeado

```bash
git clone https://github.com/tu-usuario/nombre-del-repositorio.git
cd nombre-del-repositorio
```

### 3. A trabajar

- Escribe las funciones y corre los tests cuando acabes cada una de ellas.
- Corre los tests desde el IDE para una mejor experiencia.

## Flujo de Trabajo Recomendado

1. **Fork**: Crea una copia personal del repositorio para trabajar independientemente.
2. **Work**: Implementa las funciones y pruebas en tu entorno local.
3. **Test Locally**: Ejecuta las pruebas en tu IDE para asegurar que todo funciona correctamente.
4. **Push**: Sube tus cambios a tu repositorio en GitHub.
5. **Pull Request**: Envía un Pull Request al repositorio original para revisión.
6. **CI Checks**: Verifica que los chequeos automáticos pasan exitosamente.
7. **Feedback**: Si se solicita, realiza ajustes adicionales y actualiza tu Pull Request.

## Ejecución de Pruebas

- **Desde el IDE**:
  - Ejecuta las pruebas individualmente o todas a la vez para verificar tu implementación.
- **Desde la Línea de Comandos**:
  ```bash
  ./gradlew test
  ```

## Integración Continua

- El proyecto utiliza herramientas de CI para automatizar la ejecución de pruebas.
- Es fundamental que todas las pruebas pasen antes de que se pueda fusionar el Pull Request.
- Los resultados de los chequeos de CI aparecerán automáticamente en tu Pull Request.

## Consejos Adicionales

- **Utiliza el IDE**: IntelliJ IDEA ofrece herramientas de depuración y ejecución de pruebas que facilitan el desarrollo.
- **Escribe Pruebas Exhaustivas**: Cubre tanto casos típicos como casos borde para garantizar la robustez de tus funciones.
- **Lee los Mensajes de Error**: Si una prueba falla, los mensajes de error pueden guiarte hacia la solución.


¡Buena suerte y disfruta del proceso de aprendizaje!