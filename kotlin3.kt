fun pozition(N: Int): Int {
    var position = -1
    var number: Int
    var positionCount = 0
    var newN = N
    
    while (newN > 0) {
        position++
        number = newN % 10
        newN /= 10
        if (position % 2 != 0 && number % 2 != 0) {
            positionCount++
        }
    }
    
    return if (positionCount == (position + 1) / 2 && position > 0) {
        N
    } else {
        0
    }
}

fun main() {
    println("Сколько чисел вы планируете вводить?")
    val numberCount = readLine()?.toIntOrNull() ?: 0
    
    println("Вводите числа")
    var sum = 0
    
    for (i in numberCount downTo 1) {
        val number = readLine()?.toIntOrNull() ?: 0
        sum += pozition(number)
    }
    
    println(sum)
}
