package hell5


fun findConjunction(lower0: Int, lower1: Int, higher0: Int, higher1: Int) : Boolean
{
    var returnVal = false
    if((lower0 <= higher0) and (lower1 >= higher1))
    {
        returnVal = true
    }
    else if((higher0 <= lower0) and (higher1 >= lower1))
    {
        returnVal = true
    }
    return returnVal

}

fun day4(){
    var score = 0
    readInputAsList("resources/day4")
        .map{ it ->
            val (lower, higher) = it.split(",")
            val (lower0, lower1) = lower.split("-").map{it.toInt()}
            val (higher0, higher1) = higher.split("-").map{it.toInt()}
            val l = IntRange(lower0, lower1)
            val h = IntRange(higher0, higher1)
            for (it in l)
            {
                if (it in h)
                {
                    score++
                    continue
                }
            }
            //l.forEach { it-> if (it in h) score++ }

            //if(findConjunction(lower0, lower1, higher0, higher1)) score++
        }
    println(score)
}