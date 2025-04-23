package main

import (
	"fmt"
	"os"
)

func flowers(waterCount []int, volume int) int {
	x := volume    // объем лейки
	steps := 0     // кол-во шагов

	for i := 0; i < len(waterCount); i++ {
		if x-waterCount[i] >= 0 { // если воды достаточно
			x -= waterCount[i]
			steps++
		} else { // если воды недостаточно
			x = volume // набираем лейку у реки
			steps += 2*(i+1) - 1 // шаги до реки и обратно
			x -= waterCount[i]
		}
	}
	return steps
}

func bags(flowerCount int) { // проверка входящих значений
	if flowerCount < 0 {
		fmt.Println("введено невозможное значение")
		os.Exit(0) // завершаем программу при ошибке
	}
}

func main() {
	var flowersCount int // кол-во цветов
	fmt.Print("Введите количество цветов: ")
	fmt.Scan(&flowersCount)
	bags(flowersCount)

	waterCounts := make([]int, flowersCount) // слайс для хранения потребностей цветов
	fmt.Println("Введите кол-во воды, нужное для каждого цветка:")

	for i := 0; i < flowersCount; i++ {
		fmt.Printf("%d цветок: ", i+1)
		fmt.Scan(&waterCounts[i])
		bags(waterCounts[i])
	}

	var volume int // объем лейки
	fmt.Print("Введите объем лейки: ")
	fmt.Scan(&volume)
	bags(volume)

	steps := flowers(waterCounts, volume)
	fmt.Printf("%d шагов вы сделаете\n", steps)
}
