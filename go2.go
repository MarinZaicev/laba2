package main

import (
	"fmt"
	"os"
)

// Функция замены нулей на единицы
func zamenaZero(S string, K int) int {
	maxOneCount := 0  // Максимальное значение единиц
	zeroCount := 0    // Количество нулей в текущем окне
	j := 0            // Левая граница окна

	for i := 0; i < len(S); i++ {
		if S[i] == '0' {
			zeroCount++  // Увеличиваем счетчик нулей
		}

		// Если нулей стало больше K, сдвигаем левую границу
		for zeroCount > K {
			if S[j] == '0' {
				zeroCount--  // Уменьшаем счетчик нулей
			}
			j++
		}

		// Обновляем максимальную длину последовательности
		if currentLength := i - j + 1; currentLength > maxOneCount {
			maxOneCount = currentLength
		}
	}

	return maxOneCount
}

// Проверка, что строка бинарная
func checkBinary(S string) {
	for _, char := range S {
		if char != '0' && char != '1' {
			fmt.Println("Строка бинарная и должна состоять только из 0 и 1")
			os.Exit(0)
		}
	}
}

func main() {
	var S string
	fmt.Print("Введите бинарную строку: ")
	fmt.Scanln(&S)
	checkBinary(S)

	var K int
	fmt.Print("Введите число K: ")
	_, err := fmt.Scanln(&K)
	if err != nil || K < 0 {
		fmt.Println("Данное число не может быть меньше 0")
		os.Exit(0)
	}

	result := zamenaZero(S, K)
	fmt.Printf("Максимальная длина последовательности единиц: %d\n", result)
}
