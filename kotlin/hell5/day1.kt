package hell5

fun day1() {
    val testInput: List<String> = readInputAsList("resources/day1")
    var maxSum = 0;
    var oldMaxSum = 0;
    var oldestMaxSum = 0;
    var sum = 0
    for (item in testInput)
    {
        if(item != "")
        {
            sum += item.toInt()
        }
        else
        {
            if (sum >= maxSum)
            {
                oldestMaxSum = oldMaxSum
                oldMaxSum = maxSum
                maxSum = sum
            }
            else if(sum >= oldMaxSum)
            {
                oldestMaxSum = oldMaxSum
                oldMaxSum = sum
            }
            else if(sum >= oldestMaxSum)
            {
                oldestMaxSum = sum
            }
            sum = 0
        }
    }
    println(maxSum)
    println(oldMaxSum)
    println(oldestMaxSum)
    println(maxSum + oldMaxSum + oldestMaxSum)
}