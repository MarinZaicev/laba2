package main

import (
	"fmt"
	"os"
)

func pozition(N int) int {
	pozition := -1
	var number int
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
	} else {
		return 0
	}
}

func bags(tryNumber int) {
	if tryNumber < 0 {
		fmt.Println("вводите только положительное число")
		os.Exit(0)
	}
}

func main() {
	fmt.Println("сколько чисел вы планируете вводить?")
	var numberCount int
	fmt.Scan(&numberCount)
	bags(numberCount)

	fmt.Println("вводите числа ")
	var number int
	sum := 0

	for i := numberCount; i > 0; i-- {
		fmt.Scan(&number)
		bags(number)
		sum += pozition(number)
	}

	fmt.Println(sum)
}
