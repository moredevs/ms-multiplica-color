# ms-multiplica-color

Este servicio esta encargao de listar y obtener todos los registro (colores) en su totalidad o por clave principal
y poder crear nuevo.

Tecnologias:

Spring boot Java 8
Webflux
Postgresql
Swagger
Kubernetes Google Cloud (Servidor)
Docker

Ejecutar proyecto en local

 Situarse en la raiz del poyecto y correr esta linea de codigo en la consola:

  mvn clean install spring-boot:run

  *Esto limpiara e instalara las dependencias del proyecto y ejecutara en local puerto 8080 por defecto
    - http://localhost:8080

Ejecutar proyecto docker local

 Situarse en la raiz del poyecto y correr esta linea de codigo en la consola:
   mvn clean package (construir el jar)
   docker build -t app .   (Esto construira el docker segun tenga el dockerfile)
   docker run -p 8080:8080 app (Esto ejecutara la aplicacion en el puerto 8080, teniendo como resultado)
    - http://localhost:8080


Nota: Se desplego la aplicacion en kubernetes un namespace y para que se tenga el acceso ,la url es:
	http://35.193.10.161:8080
	

El path de la aplicacion es /api/vi/
			metodo get colores
			metodo get colores/:id
			metodos post color

La ruta para el swagger documentacion es http://35.193.10.161:8080/swagger-ui.html o http://localhost:8080/swagger-ui.html en local.
Adjunto estara la collection de postman para las pruebas (archivo json para importar en postman) con el nombre : Multiplica_Talent_Color.postman_collection.json

Repositorio github:git clone https://github.com/moredevs/ms-multiplica-color.git