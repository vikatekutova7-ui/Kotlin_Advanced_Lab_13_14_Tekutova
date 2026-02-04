val rockPlanets = arrayOf<String>("Mercury",
    "Venus", "Earth", "Mars")

val gasPlanets = arrayOf("Jupiter", "Saturn",
    "Uranus", "Neptune")

val solarSystem = rockPlanets + gasPlanets

fun main() {
    val solarSystem = mutableListOf(
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune"
    )
    solarSystem.add("Pluto")
    solarSystem.remove(element = "Pluto")
    println(solarSystem.size)
//    println(solarSystem[2])
//    println(solarSystem.get(3))
//    println(solarSystem.indexOf("Earth"))
//   println(solarSystem.indexOf("Pluto"))

//    for (planet in solarSystem) {
//        println(planet)
//    }

//    solarSystem.add("Pluto")
//    solarSystem.add(3, "Theia")
//    solarSystem[3] = "Future Moon"
//    println(solarSystem[3])
//    println(solarSystem[9])
//    solarSystem.removeAt(9)

    println(solarSystem.contains("Pluto"))
//    println("Future Moon" in solarSystem)
//
}