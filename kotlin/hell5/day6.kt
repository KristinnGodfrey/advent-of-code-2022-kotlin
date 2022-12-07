package hell5

fun day6()
{
    /*
    signal is a series of seemingly random characters that the device receives one at a time
    find start-of-packet marker = sequence of 4 unique characters
     */

    /*

     */
    var input: String = readInputAsString("resources/day6")

    for (i in input.indices)
    {
        if(i < 4) continue
        var strPt1 = StringBuilder()
        for (j in 0..3)
        {
            strPt1.append(input[i-j])
        }
        if(strPt1.toString().allUnique())
        {
            println("part1: " + (i+1))
            break
        }
    } 

    for (i in input.indices)
    {
        if(i < 14) continue
        var strPt1 = StringBuilder()
        var indistinct = false
        for (j in 0..13)
        {
            var a = input[i-j]
            if (strPt1.toString().contains(a)) indistinct = true
            strPt1.append(a)
        }
        if(!indistinct){
            println("part2: " + (i+1))
            break
        }
    }
}