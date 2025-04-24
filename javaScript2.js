function zamenaZero(S, K) {
    let maxOneCount = 0;  // Максимальное значение единиц
    let zeroCount = 0;    // Количество нулей в текущем окне
    let j = 0;            // Левая граница окна
    
    for (let i = 0; i < S.length; i++) {
        if (S[i] === '0') {
            zeroCount++;  // Увеличиваем счетчик нулей
        }
        
        while (zeroCount > K) {
            if (S[j] === '0') {
                zeroCount--;  // Уменьшаем счетчик нулей
            }
            j++;
        }
        
        maxOneCount = Math.max(maxOneCount, i - j + 1);
    }
    
    return maxOneCount;
}

function checkBinary(S) {
    for (let i = 0; i < S.length; i++) {
        if (S[i] !== '0' && S[i] !== '1') {
            console.log("Строка бинарная и должна состоять только из 0 и 1");
            process.exit(0);
        }
    }
}

// Основная программа
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

readline.question('Введите бинарную строку: ', (S) => {
    checkBinary(S);
    
    readline.question('Введите число K: ', (KInput) => {
        const K = parseInt(KInput);
        
        if (isNaN(K) || K < 0) {
            console.log("Данное число не может быть меньше 0");
            process.exit(0);
        }
        
        const result = zamenaZero(S, K);
        console.log(`Максимальная длина последовательности единиц: ${result}`);
        readline.close();
    });
});
