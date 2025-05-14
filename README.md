# XLSX Number Finder Service

Микросервис для поиска N-ного минимального числа в XLSX файле

## 📋 Требования
- Java 17+
- Maven 3.9+
- Spring Boot 3.2+

## 🚀 Быстрый старт
1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/fedeyak/school_mate.git](https://github.com/Bendjaml/FindingTheNthMinimumNumber
   cd проект

2. Сборка проекта


    mvn clean package

3. Запуск приложения


    java -jar target/demo-0.0.1-SNAPSHOT.jar
Приложение доступно по адресу: http://localhost:8080

4. Использование API

Поиск N-го минимального числа

    POST /findNthMin

Параметры запроса:

    file: XLSX файл с числами (обязательный)
n: Порядковый номер минимума (целое число > 0)

Пример запроса через cURL:

    curl -X POST "http://localhost:8080/findNthMin" \
    -H "Content-Type: multipart/form-data" \
    -F "file=@numbers.xlsx" \
    -F "n=3"
Пример успешного ответа:

    json
    7
5. Формат файла

Файл должен содержать один столбец с целыми числами


### Документация

После запуска доступны:

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI спецификация: http://localhost:8080/v3/api-docs
### Конфигурация

Основные параметры (application.properties):

    properties
    # Порт приложения
    server.port=8080
    
    # Лимиты загрузки файлов
    spring.servlet.multipart.max-file-size=10MB
    spring.servlet.multipart.max-request-size=10MB
### Устранение проблем

    Проблема                         Решение
    Порт занят	                Используйте --server.port=9090
    Ошибка загрузки файла   	Проверьте формат (.xlsx) и содержимое файла
    Ошибка 500	                Смотрите логи в logs/application.log
