fun main() {
    println("Введите бинарную строку: ")
    val S = readLine() ?: ""
    
    // Проверка на бинарную строку
    for (i in S.indices) {
        if (S[i] != '0' && S[i] != '1') {
            println("Строка бинарная и должна состоять только из 0 и 1")
            return
        }
    }
    
    println("Введите число K: ")
    val K = readLine()?.toIntOrNull() ?: -1
    
    if (K < 0) {
        println("Данное число не может быть меньше 0")
        return
    }
    
    val result = zamenaZero(S, K)
    println("Максимальная длина последовательности единиц: $result")
}

fun zamenaZero(S: String, K: Int): Int {
    var maxOneCount = 0  // Максимальное значение единиц
    var zeroCount = 0    // Количество нулей в текущем окне
    var j = 0            // Левая граница окна
    
    for (i in S.indices) {
        if (S[i] == '0') {
            zeroCount++
        }
        
        while (zeroCount > K) {
            if (S[j] == '0') {
                zeroCount--
            }
            j++
        }
        
        maxOneCount = maxOf(maxOneCount, i - j + 1)
    }
    
    return maxOneCount
}
