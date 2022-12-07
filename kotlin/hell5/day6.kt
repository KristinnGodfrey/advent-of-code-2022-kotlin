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
        if(i < 4){
            continue
        }
        var strPt1 = StringBuilder()
        for (j in 0..3)
        {
            strPt1.append(input[i-j])
        }
        if(strPt1.toString().allUnique())
        {
            println(i+1)
            return
        }

    }
}