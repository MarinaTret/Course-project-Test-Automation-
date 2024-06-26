# Планирование

## 1. Перечень автоматизируемых сценариев

**Валидные вводные данные одобренной карты:**

- номер карты - 1111 2222 3333 4444
- месяц - в формате двух цифр, текущий или будущий месяц
- год - в формате последних двух цифр в диапазоне текущий-текущий+5
- владелец - любые ФИ на латинице
- CVC/CVV - 3 цифры

---
**Валидные вводные данные удаленной карты:**

- номер карты - 5555 6666 7777 8888
- месяц - в формате двух цифр, текущий или будущий месяц
- год - в формате последних двух цифр в диапазоне текущий-текущий+5
- владелец - любые ФИ на латинице
- CVC/CVV - 3 цифры  

---
---

**1. Оплата с одобренной карты с валидными данными**

**Ввести валидные данные одобренной карты**

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

- Данные отправляются в банк.  
- Появляется сообщение "Появляется сообщение "Успешно! Операция одобрена Банком"

---

**2. Покупка в кредит с одобренной карты с валидными данными**

**Ввести валидные данные одобренной карты**

**Действия:**

- Нажать кнопку "купить в кредит"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

- Данные отправляются в банк.
- Появляется сообщение "Появляется сообщение "Успешно! Операция одобрена Банком"

---

**3. Оплата с удаленной карты с валидными данными**

**Ввести валидные данные удаленной карты**

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

- Данные отправляются в банк.
- Появляется сообщение "Появляется сообщение "Ошибка! Банк отказал в проведении операции"

---

**4. Покупка в кредит с удаленной карты с валидными данными**

**Ввести валидные данные удаленной карты**

**Действия:**

- Нажать кнопку "купить в кредит"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

- Данные отправляются в банк.
- Появляется сообщение "Появляется сообщение "Ошибка! Банк отказал в проведении операции"

---

**Далее тесты для формы "Купить"**


**5. Оплата по карте с невалидным номером**

**Ввести валидные данные одобренной карты**

Поменять номер карты на 16 случайных цифр

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Данные не отправляются, появляется сообщение "Появляется сообщение "Ошибка! Банк отказал в проведении операции"

---

**6. Оплата по карте с неполным номером**

**Ввести валидные данные одобренной карты**

Поменять номер карты на "1111 2222 3333 444"

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "номер карты" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**7. Оплата услуги без указания номера карты**

**Ввести валидные данные одобренной карты**

Поменять номер карты на ""

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "номер карты" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**8. Отправка формы оплаты без указания месяца**

**Ввести валидные данные одобренной карты**

Поменять месяц на ""

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**9. Отправка формы оплаты с месяцем "00"**

**Ввести валидные данные одобренной карты**

Поменять месяц на "00"

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**10. Отправка формы оплаты с несуществующим месяцем**

**Ввести валидные данные одобренной карты**

Поменять месяц на "13"

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверно указан срок действия карты"

---

**11. Ввод одной цифры в поле "месяц"**

**Ввести валидные данные одобренной карты**

Поменять месяц на случайную цифру

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**12. Ввод трех цифр в поле "месяц"**

**Ввести валидные данные одобренной карты**

Поменять месяц на случайные три цифры

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверно указан срок действия карты"

---

**13. Ввод букв в поле "месяц"**

**Ввести валидные данные одобренной карты**

Поменять месяц на две случайные буквы

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**14. Ввод символов в поле "месяц"**

**Ввести валидные данные одобренной карты**

Поменять месяц на два символа

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "месяц" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**15. Отправка формы оплаты с пустым годом**

**Ввести валидные данные одобренной карты**

Поменять год на ""

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**16. Отправка формы оплаты с годом из прошлого**

**Ввести валидные данные одобренной карты**

Поменять год на год из прошлого

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Истёк срок действия карты"

---

**17. Отправка формы оплаты с годом, следующим за сроком действия карты**

**Ввести валидные данные одобренной карты**

Поменять год на год, больше, чем срок действия карты

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Неверно указан срок действия карты"

---

**18. Ввод трех цифр в поле "год"**

**Ввести валидные данные одобренной карты**

Поменять год на три цифры

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Неверно указан срок действия карты"

---

**19. Ввод одной цифры в поле "год"**

**Ввести валидные данные одобренной карты**

Поменять год на случайную цифру

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**20. Ввод букв в поле "год"**

**Ввести валидные данные одобренной карты**

Поменять год на две случайные буквы

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**21. Ввод символов в поле "год"**

**Ввести валидные данные одобренной карты**

Поменять год на 2 символа

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "год" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**22. Отправка формы оплаты с пустым полем "Владелец"**

**Ввести валидные данные одобренной карты**

В поле Владелец ввести ""

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "владелец" подчеркивается красным, под чертой появляется сообщение "Поле обязательно для заполнения"

---

**23. Ввод кирилицы в поле "Владелец"**

**Ввести валидные данные одобренной карты**

В поле Владелец ввести ФИ на кирилице

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "владелец" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**24. Ввод цифр в поле "Владелец"**

**Ввести валидные данные одобренной карты**

В поле Владелец ввести случайную цифру

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "владелец" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**25. Ввод символов в поле "Владелец"**

**Ввести валидные данные одобренной карты**

В поле Владелец ввести символ

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "владелец" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**26. Ввод 65 латинских букв в поле "Владелец"**

**Ввести валидные данные одобренной карты**

В поле Владелец ввести 65 букв

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "владелец" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**27. Ввод двойной фамилии через дефис в поле "Владелец"**

**Ввести валидные данные одобренной карты**

В поле Владелец ввести двойную фамилию через дефис и имя

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Данные отправляются, появляется сообщение "Появляется сообщение "Успешно! Операция одобрена Банком"

---

**28. Отправка формы оплаты с пустым полем "CVC/CVV"**

**Ввести валидные данные одобренной карты**

В поле "CVC/CVV" ввести ""

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "CVC/CVV" подчеркивается красным, под чертой появляется сообщение "Неверный формат"

---

**29. Ввод 1 цифры в поле "CVC/CVV"**

**Ввести валидные данные одобренной карты**

В поле "CVC/CVV" ввести случайную цифру

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "CVC/CVV" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**30. Ввод букв в поле "CVC/CVV"**

**Ввести валидные данные одобренной карты**

В поле "CVC/CVV" ввести 3 буквы

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "CVC/CVV" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**31. Ввод символов в поле "CVC/CVV"**

**Ввести валидные данные одобренной карты**

В поле "CVC/CVV" ввести три символа

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"

**Результат:**

Поле "CVC/CVV" подчеркивается красным, под ним появляется сообщение "Неверный формат"

---

**32. Просмотр статуса в MySQL пользователя с одобренной картой**

**Ввести валидные данные одобренной карты**

**Действия:**   

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"
- Открыть приложение DBeaver; 
- Посмотреть статус в таблице payment_entity

**Результат:**

Запросы в БД MySQL выполняются.

---

**33. Просмотр статуса оплаты в MySQL пользователя с одобренной картой**

**Ввести валидные данные одобренной карты**

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"
- Открыть приложение DBeaver;
- Посмотреть сумму покупки в таблице payment_entity

**Результат:**

Сумма покупки = 45 000

---


**34. Просмотр статуса в MySQL пользователя с удаленной картой**

**Ввести валидные данные удаленной карты**

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"
- Открыть приложение DBeaver;
- Посмотреть статус в таблице payment_entity

**Результат:**

Запрос в БД MySQL выполняются.

---

**35. Просмотр статуса оплаты в MySQL пользователя с удаленной карты**

**Ввести валидные данные удаленной карты**

**Действия:**

- Нажать кнопку "купить"
- Заполнить форму
- Нажать кнопку "продолжить"
- Открыть приложение DBeaver;
- Посмотреть сумму покупки в таблице payment_entity

**Результат:**

Покупка отклонена. Сумма покупки = 0

---
## 2. Перечень используемых инструментов с обоснованием выбора
- 2.1 платформа для написания и запуска автотестов JUnit 5 
- Выбранный язык для написания автотестов Java 11 
- Система управления проектами Gradle - более гибкая и менее многословная 
система, сама выкачивают нужные библиотеки и их зависимости
- Инструмент хранения кода - Git и GitHub - высокая доступность и производительность инфраструктуры
- Редактор кода IntelliJ IDEA 2023.3.2 - мультиязыяная, интегрирована с Git и Github
- Репортинг Allure - понятный и удобный инструмент для репортинга
- Lombok - позволяет сократить шаблонный код
- Selenide - стабильные тесты, мощные селекторы, простая конфигурация
- Паттерн Page Object - создании отдельных объектов для каждой страницы веб-приложения, 
в которых инкапсулированы все действия и элементы страницы
- Docker-compose - позволяет запускать множество контейнеров одновременно 
и маршрутизировать потоки данных между ними
- СУБД: MySQL - популярная система, которая  позволяет хранить, 
организовывать большие объемы данных, и манипулировать ими.
- Браузер: Google Chrome - в настоящее время Google Chrome один из самых используемых браузеров
- Сервис для тестирования API: Postman - позволяет создавать коллекции запросов к любому API

## 3. Перечень и описание возможных рисков при автоматизации
- Дополнительные затраты на разработку тестов
- Навыки программирования у тестировщика
- Достаточное количество тестов
- Пропуск критических багов при использовании изолированных входных данных
- Выбор неверных инструментов для тестирования 
- Обстоятельства, при которых автоматизация технически невозможна

## 4. Интервальная оценка с учётом рисков в часах
- Настройка тестовых данных - 16 
- Написание тестов - 16
- Настройка базы данных - 4
- Прогон автотестов - 2 
- Составление баг-репортов - 10
- Отчеты - 8
- Составление инструкции к автотестам - 6
- Исправление ошибок - 8

## 5. План сдачи работ: когда будут проведены автотесты, результаты их проведения и отчёт по автоматизации
- Настройка тестовых данных и тестов - 25-26.04
- Составление баг-репортов - 28.04
- Оправка работы на проверку - 30.04
