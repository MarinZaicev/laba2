function flovers(waterCount, volume) {
    let x = volume; // объем лейки
    let steps = 0; // кол-во шагов
    for (let i = 0; i < waterCount.length; i++) {
        if (x - waterCount[i] >= 0) {  // если воды для полива цветка достаточно
            x -= waterCount[i]; 
            steps++;
        }
        else if (x - waterCount[i] < 0) { // если воды для полива цветка недостаточно
            x = volume; // набираем лейку у реки
            steps += 2 * (i + 1) - 1; // прибавляем кол-во шагов от цветка до реки и обратно.
            x -= waterCount[i];
        }
    }
    return steps;
}

function bags(flovercount) { // проверяем входящие значения
    if (flovercount < 0) {
        console.log("введено невозможное значение");
        process.exit(0); // если входящее число не удовлетворяет условию, завершаем выполнение программы
    }
    return 1;
}

function main() {
    const readline = require('readline').createInterface({
        input: process.stdin,
        output: process.stdout
    });

    readline.question('Введите количество цветов: ', (floversCount) => {
        floversCount = parseInt(floversCount);
        bags(floversCount);
        
        let vecWaterCount = []; // массив для хранения потребностей цветов
        let waterCountInput = (i) => {
            if (i < floversCount) {
                readline.question(`${i + 1} цветок: `, (waterCount) => {
                    waterCount = parseInt(waterCount);
                    bags(waterCount);
                    vecWaterCount.push(waterCount);
                    waterCountInput(i + 1);
                });
            } else {
                readline.question('Введите объем лейки: ', (volume) => {
                    volume = parseInt(volume);
                    bags(volume);
                    let steps = flovers(vecWaterCount, volume);
                    console.log(`${steps} шагов вы сделаете`);
                    readline.close();
                });
            }
        };
        
        console.log("Введите кол-во воды, нужное для каждого цветка");
        waterCountInput(0);
    });
}

main();
