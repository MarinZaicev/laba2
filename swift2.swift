import Foundation

func zamenaZero(_ S: String, _ K: Int) -> Int {
    var maxOneCount = 0  // Максимальное значение единиц
    var zeroCount = 0    // Количество нулей в текущем окне
    var j = 0            // Левая граница окна
    
    let characters = Array(S)
    
    for i in 0..<characters.count {
        if characters[i] == "0" {
            zeroCount += 1  // Увеличиваем счетчик нулей
        }
        
        while zeroCount > K {
            if characters[j] == "0" {
                zeroCount -= 1  // Уменьшаем счетчик нулей
            }
            j += 1
        }
        
        maxOneCount = max(maxOneCount, i - j + 1)
    }
    
    return maxOneCount
}

func checkBinary(_ S: String) {
    for char in S {
        if char != "0" && char != "1" {
            print("Строка бинарная и должна состоять только из 0 и 1")
            exit(0)
        }
    }
}

print("Введите бинарную строку: ", terminator: "")
guard let S = readLine() else {
    print("Ошибка ввода")
    exit(0)
}
checkBinary(S)

print("Введите число K: ", terminator: "")
guard let KStr = readLine(), let K = Int(KStr) else {
    print("Ошибка ввода числа")
    exit(0)
}

if K < 0 {
    print("Данное число не может быть меньше 0")
    exit(0)
}

let result = zamenaZero(S, K)
print("Максимальная длина последовательности единиц: \(result)")
