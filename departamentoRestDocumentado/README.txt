----------------------------  DOCUMENTACION CON OpenAPI 3.0-SWAGGER -----------------------
OpenAPI 3.0 es una herramienta que integra la herramienta SWAGGER para la generación de documentación
de las API Rest que se exportan en el proyecto.
Documentación oficial:
https://springdoc.org/
Para su utilización se debe incluir la dependencia:
<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
</dependency>

Ver la documentación en FORMATO WEB: http://localhost:8083/swagger-ui/index.html
Ver la documentación en  FORMATO JSON:http://localhost:8083/v3/api-docs 


Para cambiar el path de la documentación en el fichero application.properties
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui-custom.html

Para visualizar la documentación ordenadas por nombre de métodos:
springdoc.swagger-ui.operationsSorter=method

