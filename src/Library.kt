class Library<T> {
    val items = mutableListOf<T>()
}
data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)
data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)
data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)
sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}
fun filterByYear(library: Library<LibraryItem>, year: Int): List<Book> {
    return library.items
        .filter { it is LibraryItem.BookItem }
        .map { (it as LibraryItem.BookItem).book }
        .filter { it.year == year }
}
fun sortByTitle(library: Library<LibraryItem>): List<LibraryItem> {
    return library.items.sortedBy { item ->
        when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
    }
}
fun groupByAuthor(library: Library<LibraryItem>): Map<String, List<Book>> {
    return library.items
        .filter { it is LibraryItem.BookItem }
        .map { (it as LibraryItem.BookItem).book }
        .groupBy { it.author }
}
fun calculateTotalDuration(library: Library<LibraryItem>): Int {
    return library.items
        .filter { it is LibraryItem.DVDItem }
        .map { (it as LibraryItem.DVDItem).dvd.duration }
        .sum()
}
fun main() {
    val library = Library<LibraryItem>()
    library.items.add(LibraryItem.BookItem(Book(
        "Мастер и Маргарита", "Михаил Булгаков", 1966, "978-5-04-089455-9"
    )))
    library.items.add(LibraryItem.MagazineItem(Magazine(
        "Вокруг света", 7, "July"
    )))

    library.items.add(LibraryItem.DVDItem(DVD(
        "Криминальное чтиво", "Квентин Тарантино", 154
    )))

    library.items.add(LibraryItem.BookItem(Book(
        "Война и мир", "Л.Н. Толстой", 1949, "978-5-17-095757-8"
    )))

    library.items.add(LibraryItem.DVDItem(DVD(
        "Побег из Шоушенка", "Фрэнк Дарабонт", 142
    )))
    println("Книги 1966 года: ${filterByYear(library, 1966)}")
    println("\nСортировка по названию:")
    sortByTitle(library).forEach { println(it) }
    println("\nКниги по авторам: ${groupByAuthor(library)}")
    println("\nОбщая длительность DVD: ${calculateTotalDuration(library)} мин")
}