# tp---APIs-REST-en-Spring-Boot
Descripción del proyecto y funcionalidad

Este proyecto es una API REST desarrollada con Spring Boot cuya finalidad es gestionar productos (o la entidad que utilices) mediante operaciones típicas de creación, consulta, actualización y borrado (CRUD).
Funcionalmente permite:

Crear nuevos productos mediante petición HTTP POST.

Listar todos los productos o filtrar por categoría mediante GET.

Consultar un producto concreto por su id.

Actualizar datos de un producto mediante PUT.

Eliminar un producto mediante DELETE.

Validar correctamente entradas inválidas (por ejemplo datos faltantes, formatos incorrectos) y retornar errores HTTP correspondientes (400).

Manejar el caso en que el producto no existe y retornar error 404.

Utilizar una base de datos en memoria (H2 Database) para persistencia ligera.

Exponer la documentación de la API vía Swagger UI (o mediante SpringDoc OpenAPI) para que pueda explorarse y probarse desde el navegador.

El objetivo es que funcione como un ejercicio integral de APIs REST con Spring Boot, JPA, documentación, persistencia, validación y buenas prácticas.

Tecnologías utilizadas

Java (versión que hayas usado, p.ej. Java 17)

Spring Boot (versión especificada en pom.xml)

Spring Web (para los controladores REST)

Spring Data JPA (para la persistencia de entidades)

H2 (base de datos en memoria para pruebas / desarrollo)

Swagger UI / SpringDoc OpenAPI (para la documentación de la API)

(Opcional) Validaciones con javax.validation / hibernate-validator

Maven (como gestor de proyecto)

Git + GitHub (control de versiones)

Instrucciones para clonar y ejecutar el proyecto

Clona el repositorio:

git clone https://github.com/nikitoh33/tp---APIs-REST-en-Spring-Boot.git
cd tp---APIs-REST-en-Spring-Boot


Abre el proyecto en tu IDE favorito (IntelliJ, Eclipse, VSCode) o ejecútalo desde línea de comandos.

Construye el proyecto con Maven:

./mvnw clean install


(o en Windows: mvnw.cmd clean install)

Ejecuta la aplicación:

./mvnw spring-boot:run


o, alternativamente, ejecuta el .jar generado:

java -jar target/<nombre-del-archivo>.jar


La aplicación arrancará en el puerto por defecto (por ejemplo 8080).

Accede a los endpoints REST y a la documentación Swagger (ver sección correspondiente).

Accede a la consola de H2 para ver los datos persistidos (ver sección correspondiente).

Tabla de endpoints
Método HTTP	Ruta	Descripción
GET	/api/productos	Lista todos los productos
GET	/api/productos/{id}	Obtiene el producto con el id dado
GET	/api/productos/categoria/{cat}	Lista productos filtrados por categoría
POST	/api/productos	Crea un nuevo producto
PUT	/api/productos/{id}	Actualiza el producto con el id dado
DELETE	/api/productos/{id}	Elimina el producto con el id dado

Ajusta las rutas según las que tengas implementadas en tu proyecto.

Instrucciones para acceder a Swagger UI

Una vez que la aplicación esté corriendo, abre en tu navegador:

http://localhost:8080/swagger-ui/index.html


o bien

http://localhost:8080/swagger-ui.html


(Dependiendo de la configuración)
Aquí podrás ver la documentación generada, los endpoints, los modelos (DTO/entidad) y probar directamente las peticiones desde la UI.

Instrucciones para acceder a la consola H2

También, abre en tu navegador:

http://localhost:8080/h2-console


o la ruta que hayas configurado.
Credenciales típicas (según tu application.properties o application.yml):

JDBC URL: jdbc:h2:mem:testdb (o la que uses)

Usuario: sa

Contraseña: (puede ser vacía)

Desde la consola podrás ver la tabla de productos y los datos allí persistidos tras las peticiones.

Consola H2 mostrando los datos persistidos.

Conclusiones personales sobre lo aprendido
Este proyecto me permitió consolidar varios aspectos importantes del desarrollo de APIs REST con Spring Boot. En particular, he aprendido que la separación clara entre capas (controlador, servicio, repositorio) mejora la mantenibilidad. La configuración de JPA junto con una base de datos en memoria como H2 facilita el desarrollo y las pruebas rápidas. Implementar documentación automática con Swagger UI hace que la API sea fácilmente explorada y testeada por otros desarrolladores. También comprendí la importancia de manejar errores correctamente (404 para recursos inexistentes, 400 para validaciones) para ofrecer una API robusta.

Además, trabajar con filtros (como categoría) y validaciones me ayudó a pensar en escenarios reales más allá de un CRUD básico. En resumen, este proyecto constituye una base sólida sobre la que podré seguir construyendo, por ejemplo integrando seguridad, paginación, filtros más complejos, persistencia real en producción, etc.
