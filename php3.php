<?php
function pozition($N) {
    $pozition = -1;
    $pozitionCount = 0;
    $newN = $N;
    
    while ($newN > 0) {
        $pozition++;
        $number = $newN % 10;
        $newN = (int)($newN / 10);
        if ($pozition % 2 != 0 && $number % 2 != 0) {
            $pozitionCount++;
        }
    }
    
    if (($pozitionCount == (int)(($pozition + 1) / 2)) && ($pozition > 0)) {
        return $N;
    } else {
        return 0;
    }
}

function bags($tryNumber) {
    if ($tryNumber < 0) {
        echo "вводите только положительное число" . PHP_EOL;
        exit(0);
    }
}

// Основная программа
echo "сколько чисел вы планируете вводить?" . PHP_EOL;
$numberCount = (int)fgets(STDIN);
bags($numberCount);

echo "вводите числа " . PHP_EOL;
$sum = 0;

for ($i = $numberCount; $i > 0; $i--) {
    $number = (int)fgets(STDIN);
    bags($number);
    $sum += pozition($number);
}

echo $sum . PHP_EOL;
?>
