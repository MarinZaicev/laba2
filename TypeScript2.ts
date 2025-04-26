// Функция для вычисления максимальной последовательности единиц после замены K нулей
function zamenaZero(S: string, K: number): number {
    let maxOneCount = 0;
    let zeroCount = 0;
    let left = 0;

    for (let right = 0; right < S.length; right++) {
        if (S[right] === '0') {
            zeroCount++;
        }

        // Если нулей стало больше K, двигаем левую границу
        while (zeroCount > K) {
            if (S[left] === '0') {
                zeroCount--;
            }
            left++;
        }

        // Обновляем максимальную длину
        maxOneCount = Math.max(maxOneCount, right - left + 1);
    }

    return maxOneCount;
}

// Проверка, что строка состоит только из 0 и 1
function validateBinaryString(S: string): boolean {
    for (const char of S) {
        if (char !== '0' && char !== '1') {
            return false;
        }
    }
    return true;
}

// Основная функция с вводом через prompt()
function main() {
    // Ввод строки
    const S = prompt("Введите бинарную строку (из 0 и 1):");
    
    if (!S || !validateBinaryString(S)) {
        console.log("Ошибка: строка должна содержать только 0 и 1!");
        return;
    }

    // Ввод числа K
    const KInput = prompt("Введите K (сколько нулей можно заменить):");
    const K = parseInt(KInput);

    if (isNaN(K) || K < 0) {
        console.log("Ошибка: K должно быть неотрицательным числом!");
        return;
    }

    // Вычисление и вывод результата
    const result = zamenaZero(S, K);
    console.log("Максимальная длина последовательности единиц:", result);
}

// Запуск программы
main();
