# UI Autotests

## Назначение проекта

Проект содержит UI-автотесты для учебного приложения TestRail.

Тестируемое приложение:

https://workspaceforapiandui.testrail.io

В проекте автоматизировано 10 тест-кейсов.

## Используемые инструменты

- Java 17
- Gradle
- JUnit 5
- Selenide
- DataFaker
- Google Chrome

## Требования для запуска

Для запуска проекта необходимо:

- установить Java 17;
- иметь Google Chrome;
- настроить переменные окружения для авторизации;
- иметь доступ к тестируемому приложению.

## Настройка адреса приложения

Адрес приложения по умолчанию задаётся в `TestConfig`.

При необходимости его можно переопределить без изменения исходного кода:

```powershell
.\gradlew.bat clean test -DbaseUrl=https://example.com
```

## Настройка авторизации

Логин и пароль не хранятся в исходном коде.

Необходимо создать две переменные окружения:

```text
TEST_EMAIL
TEST_PASSWORD
```

Пример для Windows PowerShell:

```powershell
setx TEST_EMAIL "your_email"
setx TEST_PASSWORD "your_password"
```

После создания переменных окружения необходимо перезапустить IntelliJ IDEA или терминал.

## Запуск тестов

Запуск всех тестов:

```powershell
.\gradlew.bat clean test
```

Запуск одного теста:

```powershell
.\gradlew.bat test --tests "tests.LoginTest.successfulLoginTest"
```

## Отчёт

После запуска тестов HTML-отчёт Gradle находится         по адресу:

```text
build/reports/tests/test/index.html
```

Скриншоты при падении UI-тестов сохраняются в:

```text
build/reports/tests/screenshotsFailedTests
```

## Соответствие ручных тест-кейсов и автотестов

| ID | Название тест-кейса | Класс и метод автотеста |
|---|---|---|
| UI-001 | Успешная авторизация | `LoginTest.successfulLoginTest()` |
| UI-002 | Неверный пароль | `LoginTest.incorrectPasswordLoginTest()` |
| UI-003 | Пустой Email | `LoginTest.emptyEmailFieldLoginTest()` |
| UI-004 | Пустой пароль | `LoginTest.emptyPasswordFieldLoginTest()` |
| UI-005 | Переход на Dashboard | `DashboardTest.openDashboardTest()` |
| UI-006 | Открытие Sample Project | `DashboardTest.openSampleProjectTest()` |
| UI-007 | Добавление проекта | `DashboardTest.createProjectTest()` |
| UI-008 | Переход в Test Cases | `ProjectTest.openTestCasesTest()` |
| UI-009 | Переход в Test Runs & Results | `ProjectTest.openTestRunsAndResultsTest()` |
| UI-010 | Создание Test Case | `ProjectTest.createTestCaseTest()` |

## Известные ограничения

- UI-007 создаёт новые проекты в учебном приложении и не удаляет их после выполнения теста.
- UI-010 создаёт новый Test Case и не удаляет его после выполнения теста.
- Для выполнения тестов требуется действующая учётная запись TestRail.
