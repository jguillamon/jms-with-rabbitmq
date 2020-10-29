# Integracion github con webclient
Microservicio que se conecta con una rabbitmq y queda a la espera de recibir mensajes.
Se proporciona un metodo POST para publicar mensajes.
#### Tecnologías
Java 11

Spring Boot 2.3.4.RELEASE

#### Configuración
Editar el fichero *application.yml* las entradas.
> **rabbitmq.host**: ip donde está la imagen docker rabbitmq corriendo
>
> **rabbitmq.port**: puerto rabbitmq
>
> **rabbitmq.user**: usuario rabbitmq
>
> **rabbitmq.password**: contraseña rabbitmq
>
> **rabbitmq.virtualhost**: virtualhost rabbitmq
>

#### Ejecución
Para probar el proceso hay que arracar primero rabbitmq con ayuda de docker
> $ docker-compose up
>

Para comprobar que está correctamente funcionando rabbitmq podemos entrar en el navegador a *http://{rabbitmq.host}:15672*
y nos pedira el usuario/contraseña.

Despues levantamos la aplicación sprint-boot y ya podemos lanzar peticiones POST sobre el servicio *http://localhost:8080/publish* 
lo que realizará un publicado del mensaje en la cola rabbitmq y el proceso que está escuchando a la espera 
de mensajes de esa cola desencadenará una escritura del mensaje en el log del programa.


