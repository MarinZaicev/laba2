import java.util.Scanner
import kotlin.system.exitProcess

fun flowers(waterCount: List<Int>, volume: Int): Int {
    var x = volume // объем лейки
    var steps = 0 // кол-во шагов

    for (i in waterCount.indices) {
        if (x - waterCount[i] >= 0) { // если воды достаточно
            x -= waterCount[i]
            steps++
        } else { // если воды недостаточно
            x = volume // набираем лейку у реки
            steps += 2 * (i + 1) - 1 // шаги до реки и обратно
            x -= waterCount[i]
        }
    }
    return steps
}

fun bags(flowerCount: Int) { // проверка входящих значений
    if (flowerCount < 0) {
        println("введено невозможное значение")
        exitProcess(0) // завершаем программу при ошибке
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    
    print("Введите количество цветов: ")
    val flowersCount = scanner.nextInt()
    bags(flowersCount)

    val waterCounts = mutableListOf<Int>()
    println("Введите кол-во воды, нужное для каждого цветка:")

    for (i in 0 until flowersCount) {
        print("${i + 1} цветок: ")
        val water = scanner.nextInt()
        bags(water)
        waterCounts.add(water)
    }

    print("Введите объем лейки: ")
    val volume = scanner.nextInt()
    bags(volume)

    val steps = flowers(waterCounts, volume)
    println("$steps шагов вы сделаете")
}
