function pozition(N) {
    let position = -1;
    let number;
    let positionCount = 0;
    let newN = N;
    
    while (newN > 0) {
        position++;
        number = newN % 10;
        newN = Math.floor(newN / 10);
        if (position % 2 !== 0 && number % 2 !== 0) {
            positionCount++;
        }
    }
    
    if ((positionCount === Math.floor((position + 1) / 2)) && (position > 0)) {
        return N;
    } else {
        return 0;
    }
}

function main() {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    rl.question('Сколько чисел вы планируете вводить?\n', (numberCount) => {
        let sum = 0;
        let count = parseInt(numberCount);
        let processed = 0;
        
        const askNumber = () => {
            if (processed < count) {
                rl.question('Введите число: ', (number) => {
                    sum += pozition(parseInt(number));
                    processed++;
                    askNumber();
                });
            } else {
                console.log('Сумма: ' + sum);
                rl.close();
            }
        };
        
        askNumber();
    });
}

main();
