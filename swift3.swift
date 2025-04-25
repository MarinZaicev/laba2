func pozition(_ N: Int) -> Int {
    var position = -1
    var number: Int
    var positionCount = 0
    var newN = N
    
    while newN > 0 {
        position += 1
        number = newN % 10
        newN /= 10
        if position % 2 != 0 && number % 2 != 0 {
            positionCount += 1
        }
    }
    
    if (positionCount == (position + 1) / 2) && (position > 0) {
        return N
    } else {
        return 0
    }
}

func main() {
    print("Сколько чисел вы планируете вводить?")
    guard let numberCount = Int(readLine() ?? "") else {
        print("Ошибка ввода")
        return
    }
    
    print("Вводите числа")
    var sum = 0
    
    for _ in stride(from: numberCount, to: 0, by: -1) {
        guard let number = Int(readLine() ?? "") else {
            print("Ошибка ввода числа")
            return
        }
        sum += pozition(number)
    }
    
    print(sum)
}

main()
