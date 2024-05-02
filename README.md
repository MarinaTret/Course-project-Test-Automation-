# Процедура запуска автотестов

1. Клонировать текущий проект при помощи команды "git clone"
2. Открыть проект в IntelliJ IDEA
3. Запустить контейнер. В терминале IntelliJ IDEA прописать команду "docker-compose up"
4. Запустить тестируемую форму SUT. В терминале IntelliJ IDEA прописать команду "java -jar artifacts/aqa-shop.jar"
5. Прогнать тесты. Запустить в терминале IntelliJ IDEA команду "./gradlew clean test"
6. Получить отчет о тестировании. Запустить в терминале IntelliJ IDEA запустить команду "./gradlew allureServe"
