package main

import (
	"fmt"
)

func pozition(N int) int {
	pozition := -1
	number := 0
	pozitionCount := 0
	newN := N

	for newN > 0 {
		pozition++
		number = newN % 10
		newN = newN / 10
		if pozition%2 != 0 && number%2 != 0 {
			pozitionCount++
		}
	}

	if (pozitionCount == (pozition+1)/2) && (pozition > 0) {
		return N
	}
	return 0
}

func main() {
	var numberCount, number, sum int

	fmt.Println("Сколько чисел вы планируете вводить?")
	fmt.Scan(&numberCount)

	fmt.Println("Вводите числа")
	for i := numberCount; i > 0; i-- {
		fmt.Scan(&number)
		sum += pozition(number)
	}

	fmt.Println(sum)
}
