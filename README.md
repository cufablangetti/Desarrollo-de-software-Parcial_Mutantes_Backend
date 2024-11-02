# DESARROLLO DE SOFTWARE - PARCIAL_MUTANTES - BACKEND
El proyecto es una solución a una prueba técnica en la que Magneto, el personaje de X-Men, necesita encontrar personas con habilidades mutantes para reclutarlas en su equipo. La idea es desarrollar una aplicación que pueda analizar el ADN de una persona y determinar si tiene características mutantes. Esta información permitirá a Magneto diferenciar a los humanos comunes de los mutantes.

Para entender si alguien es mutante o no, el proyecto analiza la secuencia de bases nitrogenadas en su ADN, que son representadas por las letras A, T, C, G. Si se encuentra que la secuencia contiene más de una serie de cuatro letras iguales de manera consecutiva en las direcciones horizontal, vertical o diagonal, el ADN de esa persona se considera mutante.

___
## NIVELES DEL PROYECTO

###  **1. DETECCION DE MUTANTES**
Implementación de una solución en Java con Spring Boot, organizada en una arquitectura de capas:
* Controladores: Se encarga de manejar las solicitudes HTTP.
* Servicios: Lógica de negocio para procesar y verificar secuencias de ADN.
* Repositorios: Gestión de persistencia de datos en una base de datos embebida.

A continuacion se podra ver el diagrama de secuencia / arquitectura del sistema, entrar al siguiente URL: https://drive.google.com/drive/folders/15sTprkAUdRDkiiDbZxai2B_Sxgjr8AhL?usp=sharing
___
###  **2. API REST**

Creación de una API REST con el servicio /mutant que verifica si una secuencia de ADN pertenece a un mutante.
### Formato de solicitud:
* Método: POST
* Endpoint: /mutant
### Respuesta:
* HTTP 200-OK si es mutante.
* HTTP 403-Forbidden si no es mutante.
___
###  **3. Persistencia y Estadísticas**
* Implementación de una base de datos embebida H2 para almacenar las secuencias de ADN verificadas (sin duplicados).
* Exposición del endpoint /stats que devuelve estadísticas sobre las secuencias analizadas en formato JSON:
```json
{
  "count_mutant_dna": 35,
  "count_human_dna": 100,
  "ratio": 0.35
}
```
* Pruebas de carga utilizando JMeter para asegurar la capacidad de soportar grandes volúmenes de tráfico.
* Pruebas Integradas: Implementación de tests automáticos con JUnit, garantizando una cobertura de código superior al 80%.
___   
## CÓMO PROBAR ENDPOINTS

### **EN POSTMAN CON LINK DE RENDER**

Desde la aplicación Postman, se podrán probar los endpoints "/mutant" y "/stats".

* `1. Endpoint "/stats"`

Crear una request de tipo "GET" y colocar como URL: https://desarrollo-de-software-parcial-mutantes.onrender.com/mutantapi/api/v1/stats . Presionar "SEND".

* `2. Endpoint "/mutant"`

Crear una request de tipo "POST" y colocar como URL: https://desarrollo-de-software-parcial-mutantes.onrender.com/mutantapi/api/v1/mutant . En el apartado de "Body", ir a la opción RAW y colocar un JSON. Presionar "SEND".

___

### **EN POSTMAN CON http://localhost:8080**
En el caso de no usar los link de render, debemos ejecutar la aplicacion y mientras este en ejecucion abrimos postman realizando los mismos pasos que anteriormente:

* `1. Endpoint "/stats"`

Crear una request de tipo "GET" y colocar como URL: http://localhost:8080/mutantapi/api/v1/stats . Presionar "SEND".

* `2. Endpoint "/mutant"`

Crear una request de tipo "POST" y colocar como URL: http://localhost:8080/mutantapi/api/v1/mutant . En el apartado de "Body", ir a la opción RAW y colocar un JSON. Presionar "SEND".
___
## JSONs DE PRUEBA

* `Filas:`

  ```json
  {
      "dna": [
          "CCCCTA",
          "TGCAGT",
          "GCTTCC",
          "CCCCTG",
          "GTAGTC",
          "AGTCAC"
      ]
  }

* `Columnas:`

  ```json
  {
      "dna": [
          "AGAATG",
          "TGCAGT",
          "GCTTCC",
          "GTCCTC",
          "GTAGTC",
          "GGTCAC"
      ]
  }

* `Diagonales principales:`

  ```json
  {
      "dna": [
          "AGAATG",
          "TACAGT",
          "GCAGCC",
          "TTGATG",
          "GTAGTC",
          "AGTCAA"
      ]
  }

* `Diagonal derecha ↘:`

  ```json
  {
    "dna": [
        "ATAATG",
        "GTTAGT",
        "GGCTCG",
        "TTGATG",
        "GTAGTC",
        "AGTCAA"
    ]
  }

* `Diagonal izquierda ↙:`

  ```json
  {
    "dna": [
        "ATAATG",
        "GTATGA",
        "GCTTAG",
        "TTTAGG",
        "GTAGTC",
        "AGTCAA"
    ]
  }

* `Filas y columnas:`

  ```json
  {
    "dna": [
        "CGATCA",
        "GATGCT",
        "TCCCCT",
        "TACAGT",
        "GTAACT",
        "ACCGTA"
    ]
  }

* `Todas las direcciones:`

  ```json
  {
    "dna": [
        "GGTGTG",
        "TCGCCG",
        "CCAAAA",
        "ACTGAT",
        "GCCAGC",
        "CTACTA"
    ]
  }

* `No mutante:`

  ```json
  {
    "dna": [
        "ATCGAT",
        "CTCTTG",
        "CAAGGC",
        "GGTATT",
        "ATCGAT",
        "AAGTCC"
    ]
  }
___
## EJECUCION DE LOS TEST
* Dentro del proyecto hay una carpeta test y dentro de la misma se encuentra "MutantServiceTest". La ejecutamos y en la consola nos mostrara los resultados.
___
## GUIA DE DESCARGA DEL PROYECTO

* Para ejecutar el proyecto, primero descarga el archivo ZIP, luego extrae el contenido del mismo ZIP. Asegúrate de tener Java y Gradle instalados en tu sistema. Configura las propiedades de la base de datos H2 en el archivo application.properties. Una vez configurado, compila y ejecuta el proyecto.La API estará disponible en http://localhost:8080 para que puedas probar los endpoints con herramientas como Postman.


## * `TRABAJO REALIZADO POR FACUNDO BLANGETTI 3K10`
