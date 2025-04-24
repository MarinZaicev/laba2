<?php
function zamenaZero($S, $K) {
    $maxOneCount = 0;
    $zeroCount = 0;
    $j = 0;
    
    for ($i = 0; $i < strlen($S); $i++) {
        if ($S[$i] == '0') {
            $zeroCount++;
        }
        
        while ($zeroCount > $K) {
            if ($S[$j] == '0') {
                $zeroCount--;
            }
            $j++;
        }
        
        $maxOneCount = max($maxOneCount, $i - $j + 1);
    }
    
    return $maxOneCount;
}

function checkBinary($S) {
    for ($i = 0; $i < strlen($S); $i++) {
        if ($S[$i] != '0' && $S[$i] != '1') {
            echo "Строка бинарная и должна состоять только из 0 и 1";
            exit(0);
        }
    }
}

// Основная программа
echo "Введите бинарную строку: ";
$S = trim(fgets(STDIN));
checkBinary($S);

echo "Введите число K: ";
$K_input = trim(fgets(STDIN));
$K = intval($K_input);

if ($K < 0) {
    echo "Данное число не может быть меньше 0";
    exit(0);
}

$result = zamenaZero($S, $K);
echo "Максимальная длина последовательности единиц: " . $result . "\n";
?>
