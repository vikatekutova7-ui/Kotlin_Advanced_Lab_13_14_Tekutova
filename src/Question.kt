class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Dificulty
)
enum class Dificulty{
    EASY,
    MEDIUM,
    HARD
}
fun main() {
    val question1 = Question<String>(
        questionText = "Речка спятила с ума — По домам пошла сама. ___",
        answer = "водопровод",
        Dificulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        questionText = "Небо зелёное. Правда или ложь",
        answer = false,
        Dificulty.EASY
    )
    val question3 = Question<Int>(
        questionText = "Сколько дней между полнолуниями?",
        answer = 28,
        Dificulty.HARD
    )
    println(question1.answer)
    println(question2.answer)
    println(question3.answer)
}