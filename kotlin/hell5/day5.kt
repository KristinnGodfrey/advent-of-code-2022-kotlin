package hell5

import java.util.ArrayDeque



fun day5()
{
    var stacks = readInputAsString("resources/day5").substringBeforeLast("]") + "]"
    stacks = stacks.replace("]         ", "] [ ] [ ] ").replace("]     [", "] [ ] [").replace("    ", "[ ] ")
    var instruction = "m" + readInputAsString("resources/day5").substringAfter("m")

    stacks = stacks.replace("[ ]", "[]").replace("\n", " ")
    var listStacks = stacks.split(" ")
    /*
    [ ] [ ] [ ] [ ] [ ] [ ] [Z] [W] [Z]
    [ ] [ ] [D] [M] [ ] [ ] [L] [P] [G]
    [ ] [S] [N] [R] [ ] [ ] [S] [F] [N]
    [ ] [N] [J] [W] [ ] [J] [F] [D] [F]
    [N] [H] [G] [J] [ ] [H] [Q] [H] [P]
    [V] [J] [T] [F] [H] [Z] [R] [L] [M]
    [C] [M] [C] [D] [F] [T] [P] [S] [S]
    [S] [Z] [M] [T] [P] [C] [D] [C] [D]
     */
    var stack1 = ArrayDeque<Char>()
    var stack2 = ArrayDeque<Char>()
    var stack3 = ArrayDeque<Char>()
    var stack4 = ArrayDeque<Char>()
    var stack5 = ArrayDeque<Char>()
    var stack6 = ArrayDeque<Char>()
    var stack7 = ArrayDeque<Char>()
    var stack8 = ArrayDeque<Char>()
    var stack9 = ArrayDeque<Char>()
    var stackLists = listOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9)
    for(i in listStacks.indices)
    {
        var ind = i % 9
        if(listStacks[i][1] != ']')
        {
            stackLists[ind].push(listStacks[i][1])
        }
    }
    var reversedStackLists : List<List<Char>> = stackLists.map { it -> it.reversed() }

    val listOfInstructions = instruction.split("\n")


    var mutablePt1 = reversedStackLists.map { it-> ArrayDeque(it) }.toMutableList()
    var mutablePt2 = reversedStackLists.map { it-> ArrayDeque(it) }.toMutableList()

    // part 1
    for (str in listOfInstructions){
        var move = str.substringAfter("move ").split(" ")[0].toInt() - 1
        var from = str.substringAfter("from ").take(1).toInt() -1
        var to = str.substringAfter("to ").take(1).toInt() -1

        for (i in 0..move)
        {
            mutablePt1[to].push(mutablePt1[from].pop())
        }
    }
    print("part1: ")

    for( it in mutablePt1)
    {
        print(it.peek())
    }
    println()

    //part 2
    for (str in listOfInstructions){
        var move = str.substringAfter("move ").split(" ")[0].toInt() - 1
        var from = str.substringAfter("from ").take(1).toInt() -1
        var to = str.substringAfter("to ").take(1).toInt() -1

        var listToPush = mutableListOf<Char>()
        for (i in 0..move)
        {
            listToPush.add(mutablePt2[from].pop())
        }
        listToPush = listToPush.asReversed()
        for (i in listToPush)
        {
            mutablePt2[to].push(i)
        }
    }
    print("part2: ")
    for( it in mutablePt2)
    {
        print(it.peek())
    }

}