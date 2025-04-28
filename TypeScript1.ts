function flovers(waterCount: number[], volume: number): number {
    let x: number = volume;
    let steps: number = 0;
    for (let i = 0; i < waterCount.length; i++) {
        if (x < waterCount[i]){
            steps++;
        }
        else if (x - waterCount[i] >= 0) {
            x -= waterCount[i]; 
            steps++;
        }
        else if (x - waterCount[i] < 0) {
            x = volume;
            steps += 2 * (i + 1) - 1;
            x -= waterCount[i];
        }
    }
    return steps;
}

function bags(flovercount: number): void {
    if (flovercount < 0) {
        console.log("введено невозможное значение");
        throw new Error("Invalid input");
    }
}

async function main(): Promise<void> {
    console.log("Введите количество цветов: ");
    let floversCount: number = parseInt(await prompt());
    bags(floversCount);
    
    let vecWaterCount: number[] = [];
    console.log("Введите кол-во воды, нужное для каждого цветка ");
    for (let i = 0; i < floversCount; i++) {
        console.log(`${i + 1} цветок `);
        let waterCount: number = parseInt(await prompt());
        bags(waterCount);
        vecWaterCount.push(waterCount);
    }
    
    console.log("Введите объем лейки: ");
    let volume: number = parseInt(await prompt());
    bags(volume);
    
    let steps: number = flovers(vecWaterCount, volume);
    console.log(`${steps} шагов вы сделаете`);
}

// Простейшая реализация prompt для браузера
function prompt(): Promise<string> {
    return new Promise(resolve => {
        const input = window.prompt("Введите значение:");
        resolve(input || "");
    });
}

main().catch(console.error);
