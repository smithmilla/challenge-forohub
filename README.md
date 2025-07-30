# 💬 Foro HUB - Challenge Alura LATAM
Proyecto Java de foro para el registro y gestion de topicos de un foro.

## 🎯 Descripción
Foro HUB es una aplicación web desarrollado como parte del Challenge de ALURA LATAM, cuyo objetivo es permitir a los usuarios:
- Loguearse en el sistema de topicos.
- Registrar Topicos.
- Modificar Topicos.
- Listar todos los tópicos.
- Listar por un tópico en específico.
- Eliminar un tópico.

## ⚙️ Tecnologías utilizadas
- 💻 Java 17
- ☕ Spring Boot 3
- 🛢️ JPA / Hibernate
- 🐘 MySQL
- 🌐 Consumo de API REST
- 📦 Maven
- 🔍 JPQL para consultas personalizadas
- 🔧 Lombok
- 🔐 Auth0 (JWT Token)
- 🐦 Flyway
- 🛡️ Spring Security

## 🏗️ Funcionalidades principales
- Autentication con Auth0 (JWT Token) para los usuarios.
- Registrar topicos.
- Listar topicos paginados (posibilidad de filtrar por curso).
- Listar un topico en especifico a traves de su ID.
- Modificar un topico ya registrado.
- Eliminar un topico registrado.

## 🛠️ Como ejecutar el proyecto
```bash
# Clona el repositorio
git clone https://github.com/smithmilla/challenge-forohub.git
```

```bash
# Configura tu base de datos MySQL
CREATE DATABASE forohub_api
```

```bash
# Modifica el archivo application.properties con tus credenciales:
spring.datasource.url=jdbc:mysql://localhost/forohub_api
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CLAVE

server.port=9090 <- EN CASO TENGAS CONFLICTO CON PUERTOS USADOS
api.security.token.secret=${JWT_SECRET_VOLLMED:12345678} <- RECUERDA DEFINIR TU TOKEN COMO VARIABLE DE ENTORNO, EN TODO CASO USAR UNA POR DEFECTO
```

```bash
# Para mayor flexibilidad establece variables gloables en POSTMAN o INSOMNIA
"bearer": "TU_JWT_GENERADO_AL_INICIAR_SESION"
"BASE_URL": "TU_URL" (ej: http://localhost:9090)
```

```bash
# Recuerda registrar tu usuario en la tabla Usuarios, a continuacion te dejo un script de ejemplo que puedes usar:
INSERT INTO usuarios
VALUES(null,
'smith.milla@mail.com',
'$2a$10$1Awmu6wAEo05tX1I9IloJuOV7.3KHXMSPsX9//nX.y34OLnyvrHay'
);
```

```bash
# Archivos de Insomnia - Puedes importar las peticiones directamente desde la carpeta:
imsomnia
 - Project ForoHUB Requests_Insomnia_2025-07-29.yaml
 - Project ForoHUB_Requests_Insomnia_2025-07-29.har
```

## 🙌 Contribuciones
¡Las contribuciones son bienvenidas! Siéntete libre de abrir un issue o hacer un pull request.

## 📄 Licencia
Este proyecto está bajo la licencia MIT.

## ✨ Autor
Desarrollado con 💪‍🧑‍💻️ por [smithmilla](https://github.com/smithmilla/)
<p align="left">
    <img src="https://github.com/smithmilla.png"
            width="100px"
            alt="Avatar del autor">
</p>
