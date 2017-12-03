# developer-test
Simple application docker+spring-boot+angularjs+activemq+mysql

Projeto Teste

Para executar

```sh
## build modules
docker build -t ui/static-web AngularDocker/

cd common
mvn install
cd..

cd api
mvn clean package docker:build
cd..

cd shopping
mvn clean package docker:build
cd..

cd payment
mvn clean package docker:build
cd..

##Run instances
docker-compose up

No browser: {{docker-ip}}:80

--- | ---
{{docker-ip}}:3306 | Mysql (root/root) - Schema integritas.
