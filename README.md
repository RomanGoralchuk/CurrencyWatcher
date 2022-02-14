# CryptoСurrency watcher
### Functionality
•	Просмотр списка доступных криптовалют (REST-метод)
•	Просмотр актуальной цены для указаной криптовалюты (REST-метод - код валюты передается пользователем)
•	Записать в лог сообщение о изменении цены более чем на 1%. Для это пользователь регистрирует себя с помощью REST-метода notify и передает свое имя(username) и код криптовалюты(symbol). В момент регистрации cохраняется текущая цена указаной криптовалюты с привязкой к пользователю. Как только актуальная цена для указаной валюты поменялась более чем на 1%., в лог сервера выводится сообщение уровня WARN в котором указан: код валюты, имя пользователя и процент изменения цены с момента регистрации.
### Requirements
•	Вы можете использовать Java или Kotlin (любой версии)
•	Используте Spring или Spring Boot (можно использовать https://start.spring.io/ для ускорения)
•	Актуальные цены храните в реляционной базе - можно использовать любую (H2, Mysql, Postgres,…)
•	Cписок доступных криптовалют предопределен и является частью конфигурации сервера
Список валют:
[ {“id”:”90”,”symbol”:”BTC”}, {“id”:”80”,”symbol”:”ETH”}, {“id”:”48543”,”symbol”:”SOL”} ]
•	Раз в минуту актуальные цены для доступных криптовалют запрашиваются c внешнего источника CoinLore и сохраняются в базу данных.
•	Что бы получить актуальные цену по коду криптовалюты используйте open API Crypto API | CoinLore
Меthod Ticker (Specific Coin): https://api.coinlore.net/api/ticker/?id=90 (BTC)
•	Когда пользователь запрашивает актуальную цену для указаной криптовалюты - данные должны быть получены из базы данных

### Technologies
* Java 11
* Maven
* FlyWay
* Slf4j+Logback
* MariaDB
* DBPool Apache
* Docker-compose
* Hibernate / JPA
* Jetty
* Jackson
* Spring
* SpringBoot

### How to run
Start scripts:
* `docker-compose up`
* `mvn compile flyway:migrate`
* `mvn spring-boot:run`

### How to use
* / .....(GET (message))
* /currencies .....(GET (currency list))
* /currencies/48543 .....(GET (currency details))
* /currencies/90 .....(GET (currency details))
* /currencies/80 .....(GET (currency details))
* /notes .....(POST (user`s notes))

### How this work
Every 60 seconds my app connects to the api.coinlore.net and updates the actual data in its repository.
Users can take notes.
Every 5 second my app checks user notes and compares it with live prices.
If the current price has changed by more than 1 percent - displays a message in the log.

### Additional Info
In the project directory is json document for Postman
+ [Postman file](Watcher.postman_collection.json)

