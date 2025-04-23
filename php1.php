<?php
function flovers($waterCount, $volume) {
    $x = $volume; // объем лейки
    $steps = 0; // кол-во шагов
    for ($i = 0; $i < count($waterCount); $i++) {
        if ($x - $waterCount[$i] >= 0) {  // если воды для полива цветка достаточно
            $x -= $waterCount[$i]; 
            $steps++;
        }
        else if ($x - $waterCount[$i] < 0) { // если воды для полива цветка недостаточно
            $x = $volume; // набираем лейку у реки
            $steps += 2 * ($i + 1) - 1; // прибавляем кол-во шагов от цветка до реки и обратно.
            $x -= $waterCount[$i];
        }
    }
    return $steps;
}

function bags($flovercount) { // проверяем входящие значения
    if ($flovercount < 0) {
        echo "введено невозможное значение\n";
        exit(0); // если входящее число не удовлетворяет условию, завершаем выполнение программы
    }
    return 1;
}

// Основная программа
echo "Введите количество цветов: ";
$floversCount = (int)trim(fgets(STDIN));
bags($floversCount);

$vecWaterCount = array(); // массив для хранения потребностей цветов
echo "Введите кол-во воды, нужное для каждого цветка:\n";
for ($i = 0; $i < $floversCount; $i++) {
    echo ($i + 1) . " цветок: ";
    $waterCount = (int)trim(fgets(STDIN));
    bags($waterCount);
    $vecWaterCount[$i] = $waterCount;
}

echo "Введите объем лейки: ";
$volume = (int)trim(fgets(STDIN));
bags($volume);

$steps = flovers($vecWaterCount, $volume);
echo "Результат: " . $steps . " шагов вы сделаете\n";
?>
