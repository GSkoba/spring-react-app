# Simple todo app (spring + react)

## Запуск
Сборка и запуск backend
```
$ gradle build
$ gradle run
```
Сборка и запуск frontend
```
$ yarn install
$ yarn start
```
## Docker 
Сборка image backend
```
$ docker build . -t nx-backend
```
Запуск и настройка окружения 
```
$ docker network create nx-workshop
$ docker run --name mymongo -p 27017:27017 --rm --network nx-workshop mongo
$ docker run -d --name nx-workshop --network nx-workshop -p 8080:8080 -e MONGO_HOST=mongodb://mymongo:27017/dev nx-backend
```
## Bonus 
Что можно сделать в данном проекте и закинуть пр на проверку:
* Dockerfile для frontend и настройка совместного запуска 
* Авторизация (авторизация на строне сервера, jwt tokens)
* Свой css 
* Автотесты
* Реляционная база данных 
* любые фичи на ваш вкус
#### Оформление pull-request
Форкните, сделайте ветку от мастера (где имя ветки ваш никнейм или фамилия), делаете фичу, создаете pr с [target нa репозиторий](https://github.com/GSkoba/spring-react-app)