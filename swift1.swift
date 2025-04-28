import Foundation

func flovers(waterCount: [Int], volume: Int) -> Int {
    var x = volume // объем лейки
    var steps = 0 // кол-во шагов
    for i in 0..<waterCount.count {
        if x < waterCount[i] {
            steps += 1
        }
        else if x - waterCount[i] >= 0 {  // если воды для полива цветка достаточно
            x -= waterCount[i]
            steps += 1
        }
        else if x - waterCount[i] < 0 { // если воды для полива цветка недостаточно
            x = volume // набираем лейку у реки
            steps += 2 * (i + 1) - 1 // прибавляем кол-во шагов от цветка до реки и обратно.
            x -= waterCount[i]
        }
    }
    return steps
}

func bags(flovercount: Int) { // проверяем входящие значения
    if flovercount < 0 {
        print("введено невозможное значение")
        exit(0) // если входящее число не удовлетворяет условию, завершаем выполнение программы
    }
}

func main() {
    print("Введите количество цветов: ", terminator: "")
    guard let floversCountInput = readLine(), let floversCount = Int(floversCountInput) else {
        print("Ошибка ввода")
        return
    }
    bags(flovercount: floversCount)
    
    var vecWaterCount = [Int](repeating: 0, count: floversCount) // массив для хранения потребностей цветов
    print("Введите кол-во воды, нужное для каждого цветка")
    
    for i in 0..<floversCount {
        print("\(i + 1) цветок ", terminator: "")
        guard let waterCountInput = readLine(), let waterCount = Int(waterCountInput) else {
            print("Ошибка ввода")
            return
        }
        bags(flovercount: waterCount)
        vecWaterCount[i] = waterCount
    }
    
    print("Введите объем лейки: ", terminator: "")
    guard let volumeInput = readLine(), let volume = Int(volumeInput) else {
        print("Ошибка ввода")
        return
    }
    bags(flovercount: volume)
    
    let steps = flovers(waterCount: vecWaterCount, volume: volume)
    print("\(steps) шагов вы сделаете")
}

main()
