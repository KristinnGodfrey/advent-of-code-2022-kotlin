package hell5

fun mapScore(culpritChar: Char) : Int
{
    val alphabet = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    alphabet.forEachIndexed{ ind, value -> if (culpritChar == value) return ind + 1}
    return -1
}
fun findCulprit(firstHalf: String, secondHalf: String) :Char
{
    firstHalf.forEach { it -> secondHalf.forEach { el -> if(it == el) return el} }
    println("miss")
    return '-'
}
fun day3(){
    var score = 0
    readInputAsList("resources/day3")
         .forEach { el-> el.chunked(el.length/2)
            .let { a -> score += mapScore(findCulprit(a[0],a[1]))}  }
    println("part1: " + score)

    score = 0

    readInputAsList("resources/day3")
        .chunked(3)
        .forEach first@ { a ->
            a[0].forEach{ it ->
                if (a[1].contains(it) and a[2].contains(it)){
                    score += mapScore(it)
                    return@first
                }
            }
        }
    println("part2: " + score)
}