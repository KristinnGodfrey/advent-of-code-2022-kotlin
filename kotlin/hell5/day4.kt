package hell5

fun findFullyContained(lowerRange: IntRange, higherRange: IntRange) : Boolean
{
    return (lowerRange.first <= higherRange.first) && (lowerRange.last >= higherRange.last)
           || (higherRange.first <= lowerRange.first) && (higherRange.last >= lowerRange.last)
}
fun findOverlap(lowerRange: IntRange, higherRange: IntRange) : Boolean
{
    lowerRange.forEach { it -> if (higherRange.contains(it)) return true }
    return false
}

fun day4(){
    var scorePt1 = 0
    var scorePt2 = 0
    readInputAsList("resources/day4")
        .map{ it ->
            val (lower, higher) = it.split(",")
            val (lowerStart, lowerEnd) = lower.split("-").map{it.toInt()}
            val (higherStart, higherEnd) = higher.split("-").map{it.toInt()}
            val l = IntRange(lowerStart, lowerEnd)
            val h = IntRange(higherStart, higherEnd)

            if(findFullyContained(l,h)) scorePt1++
            if(findOverlap(l,h)) scorePt2++
        }
    println("part 1: " + scorePt1)
    println("part 2: " + scorePt2)
}