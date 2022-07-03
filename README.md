# restempresa

# Programa 3

## Requisitos:
    • Tener instalado Java 11
    • Tener instalado MySQL 8
    • Tener Instalado Maven y configurada su variable de entorno

- Repositorio: https://github.com/BryanBmmF/restempresa.git

## Pasos antes de correr el programa:
    • Ejecutar el script de la base de datos  llamado “empresa_script.sql”  ubicado en la carpeta   /bd
    • Cambiar las credenciales de acceso a la base datos dentro del archivo “application.properties” ubicado en la carpeta   /src/main/resources/
        ◦ spring.datasource.username=USER_DE_SU_INSTANCIA_LOCAL
        ◦ spring.datasource.password=PASSWORD_DE_SU_INSTANCIA_LOCAL

## Correr el programa:
    • Abrir una terminal desde el directorio raiz del proyecto y ejecutar los siguientes comandos para compilar de nuevo y empaquetar la aplicación
        ◦ mvn compile
        ◦ mvn package
    • Luego de empaquetar el programa ir a la carpeta   /target     aquí se encontrara un archivo .jar llamado “restempresa-0.0.1-SNAPSHOT.jar “   .Abrir una terminal desde esta ruta y ejecutar el comando
        ◦ java -jar restempresa-0.0.1-SNAPSHOT.jar

## Después de correr el programa, probar la api desde postmam o cualquier otro cliente HTTP usando los siguientes ejemplos.

# Ejemplos  API REST:

## 1. Registrar Empresa:

Metodo: POST
Url: http://localhost:8082/api/rest/v1/empresa/registrar
Request:
{
"nombre": "empresa1",
"numeroNit": "12345678",
"fechaFundacion": "1997-08-02",
"direccion": "2 AV zona 3 San Pedro Sac. Guatemala"

}

Response:
{
"mensaje": "La empresa empresa1 se registro exitosamente"
}

## 2. Actualizar Empresa por ID:

	- Metodo: PUT
	- Url: http://localhost:8082/api/rest/v1/empresa/actualizar/1
	- Request:{"nombre": "empresa1 actualizada","numeroNit": "87654321","fechaFundacion": "1990-08-02","direccion": "3 AV zona 3 San Pedro Sac. Guatemala"}


	- Response:{"mensaje": "La empresa con ID 1 se actualizo exitosamente"}

## 3. Recuperar Empresa por ID:

	- Metodo: GET
	- Url: http://localhost:8082/api/rest/v1/empresa/buscarEmpresaID/1

	- Response:{"id": 1,"nombre": "empresa1 actualizada","numeroNit": "87654321","fechaFundacion": "1990-08-01","direccion": "3 AV zona 3 San Pedro Sac. Guatemala"}


## 4. Recuperar Empresa por Nombre:

	- Metodo: GET
	- Url: http://localhost:8082/api/rest/v1/empresa/buscarEmpresaNombre/empresa1 actualizada

	- Response:{"id": 1,"nombre": "empresa1 actualizada","numeroNit": "87654321","fechaFundacion": "1990-08-01","direccion": "3 AV zona 3 San Pedro Sac. Guatemala"}

## 5. Recuperar Empresa por Numero de NIT:

	- Metodo: GET
	- Url: http://localhost:8082/api/rest/v1/empresa/buscarEmpresaNit/87654321
	- Response:{"id": 1,"nombre": "empresa1 actualizada","numeroNit": "87654321","fechaFundacion": "1990-08-01","direccion": "3 AV zona 3 San Pedro Sac. Guatemala"}

## 6. Eliminar Empresa por ID:

	- Metodo: DELETE
	- Url: http://localhost:8082/api/rest/v1/empresa/eliminar/1

	- Response:{"mensaje": "La empresa se elimino correctamente !!!"}
