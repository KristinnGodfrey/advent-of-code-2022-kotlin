package hell5
fun calculateScore(opponent: String, player: String): Int{
    when(opponent){
        // rock
        "A" -> {
            when (player){
                "X" -> return 1 + 3 // rock
                "Y" -> return 2 + 6 // paper
                "Z" -> return 3 + 0 // scissors
            }
        }
    // paper
    "B" -> {
        when (player) {
            "X" -> return 1 + 0 // rock
            "Y" -> return 2 + 3 // paper
            "Z" -> return 3 + 6 // scissors
        }
    }
    // scissors
    "C" -> {
        when (player) {
            "X" -> return 1 + 6 // rock
            "Y" -> return 2 + 0 // paper
            "Z" -> return 3 + 3 // scissors
        }
    }
    else -> println("nothing")
    }
    return 0
}

fun calculateScorePt2(opponent: String, player: String): Int{
    val mapSignsEqual = mapOf(
        "A" to "X",
        "B" to "Y",
        "C" to "Z"
    )
    val mapSignsLosers = mapOf(
        "A" to "Z",
        "B" to "X",
        "C" to "Y"
     )
    val mapSignsWinners = mapOf(
        "A" to "Y",
        "B" to "Z",
        "C" to "X"
    )
    when(player){
        "X"->return calculateScore(opponent,mapSignsLosers.getValue(opponent))
        "Y"->return calculateScore(opponent,mapSignsEqual.getValue(opponent))
        "Z"->return calculateScore(opponent,mapSignsWinners.getValue(opponent))
    }
    return 0
}
fun day2() {
    var score = 0
     readInputAsList("resources/day2")
        .forEach{ match -> val (opponent,player) = match.split(" "); score += calculateScore(opponent,player) }
    println("part1: " + score)

    score = 0
    readInputAsList("resources/day2")
        .forEach{ match -> val (opponent,player) = match.split(" "); score += calculateScorePt2(opponent,player) }
    println("part2: " + score)
}