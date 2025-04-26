// Функция для проверки числа по условиям задачи
function checkNumber(N: number): number {
    let position = -1;
    let digit;
    let oddPositionOddDigitCount = 0;
    let tempN = N;
    
    while (tempN > 0) {
        position++;
        digit = tempN % 10;
        tempN = Math.floor(tempN / 10);
        
        if (position % 2 !== 0 && digit % 2 !== 0) {
            oddPositionOddDigitCount++;
        }
    }
    
    const expectedCount = Math.floor((position + 1) / 2);
    return (oddPositionOddDigitCount === expectedCount && position > 0) ? N : 0;
}

// Функция проверки ввода
function validateInput(input: number): void {
    if (isNaN(input) || input < 0) {
        console.log("Ошибка: вводите только положительные числа");
        throw new Error("Invalid input");
    }
}

// Основная функция с использованием prompt()
function main() {
    // Ввод количества чисел
    const countInput = prompt("Сколько чисел вы планируете вводить?") || "0";
    const numberCount = parseInt(countInput);
    validateInput(numberCount);

    let sum = 0;
    
    // Ввод каждого числа
    for (let i = 0; i < numberCount; i++) {
        const numInput = prompt(`Введите число ${i + 1}:`) || "0";
        const num = parseInt(numInput);
        validateInput(num);
        sum += checkNumber(num);
    }
    
    console.log("Результат:", sum);
}

// Запуск программы
main();
