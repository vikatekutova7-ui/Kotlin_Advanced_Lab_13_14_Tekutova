# Лабораторная работа №13-14
Коллекции, обобщения и функциональный стиль в Kotlin
## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin,
которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:
- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
Все примеры ориентированы на практическое применение и подготовку к разработке
мобильных приложений.
## Как запустить проект
Клонируйте репозиторий:
```bash
git clone <https://github.com/vikatekutova7-ui/Kotlin_Advanced_Lab_13_14_Tekutova.git>
```
## Примеры
### 1. Обобщённые типы (Generics)
Изучены принципы создания универсальных классов, работающих с разными типами данных.
```kotlin
   class Question<T>(
   val questionText: String,
   val answer: T,
   val difficulty: Difficulty
   )
```
###  2. Enum классы
Использование перечислений для ограничения допустимых значений.
```kotlin
enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
```
### 3. Data классы
Классы для хранения данных с автоматически генерируемыми методами.
```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
```
### 4.  Singleton объекты
Создание объектов в единственном экземпляре.
```kotlin
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}
```

### 5.  Extension функции и свойства
Расширение возможностей существующих классов без наследования.
```kotlin
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered."

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}
```
### 6.  Scope функции
Функции для работы с объектами и их контекстом.

```kotlin
question1.let {
    println(it.questionText)
    println(it.answer)
    println(it.difficulty)
}
```
###  7. Коллекции Kotlin
**Массивы (Arrays)**

```kotlin
val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
```

**Списки (Lists)**
```kotlin
val solarSystem = mutableListOf(
    "Mercury", "Venus", "Earth", "Mars",
    "Jupiter", "Saturn", "Uranus", "Neptune"
)
```
**Множества (Sets)**
```kotlin
val solarSystem = mutableSetOf(
    "Mercury", "Venus", "Earth", "Mars",
    "Jupiter", "Saturn", "Uranus", "Neptune"
)
```
**Map коллекции**
```kotlin
val solarSystem = mutableMapOf(
    "Mercury" to 0, "Venus" to 0, "Earth" to 1, "Mars" to 2,
    "Jupiter" to 79, "Saturn" to 82, "Uranus" to 27, "Neptune" to 14
)
```
###  8. Функции высшего порядка
**Основные функции**
```kotlin
fun displayMessage(mes: () -> Unit) {
    mes()
}

fun action(n1: Int, n2: Int, op: (Int, Int) -> Int) {
    val result = op(n1, n2)
    println(result)
}
```
**Функции с коллекциями**
  * **forEach()**: выполнение действия для каждого элемента
  * **map()**: преобразование элементов
  * **filter()**: фильтрация элементов
  * **groupBy()**: группировка по ключу
  * **fold()**: аккумуляция значений
  * **sortedBy()**: сортировка по свойству
```kotlin
val fullMenu = cookies.map {
    "${it.name} - $${it.price}"
}

val softBakedMenu = cookies.filter {
    it.softBaked
}

val groupedMenu = cookies.groupBy { it.softBaked }

val totalPrice = cookies.fold(0.0) { total, cookie ->
    total + cookie.price
}

val alphabeticalMenu = cookies.sortedBy { it.name }
```

## Автор
Текутова Виктория Денисовна
## Лицензия
Проект создан в учебных целях.