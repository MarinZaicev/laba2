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

echo "сколько чисел вы планируете вводить?\n";
$numberCount = (int)trim(fgets(STDIN));

echo "вводите числа\n";
$sum = 0;

for ($i = $numberCount; $i > 0; $i--) {
    $number = (int)trim(fgets(STDIN));
    $sum += pozition($number);
}

echo $sum . "\n";
?>
