# developer-test
Simple application docker+spring-boot+angularjs+activemq+mysql

Project Test

# RUNNING (WARNING!!! WAIT-FOR-IT MYSQL NOT CONFIGURED)

```sh
## build modules
docker build -t integritas/ui ui/

cd common
mvn clean install
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

No browser: {{docker-ip}}:80 (Apache, change port at ui/httpd.conf)

--- | ---
{{docker-ip}}:3306 | Mysql (root/root) - Schema integritas.
# Sample Data in insert_products.sql.
