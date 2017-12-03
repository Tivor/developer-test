# developer-test
Simple application docker+spring-boot+angularjs+activemq+mysql

Projeto Teste

Para executar

```sh
## build docker images
mvn clean install

##should display three freshly built docker images
docker images

##start up all instances
docker-compose up

No browser: {{docker-ip}}:80

Address | Description
--- | ---
{{docker-ip}}:3306 | Mysql (root/root) - Schema integritas.
