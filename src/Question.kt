data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Dificulty
)
enum class Dificulty{
    EASY,
    MEDIUM,
    HARD
}
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}
class Quiz:ProgressPrintable {
    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(times = Quiz.answered) { print(" ") }
        repeat(times = Quiz.total - Quiz.answered) { print(" ") }
        println()
        println(progressText)
    }
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
    companion object StudentProgress{
        var total: Int=10
        var answered: Int=3
    }
}

fun main() {
    Quiz().printProgressBar()
}