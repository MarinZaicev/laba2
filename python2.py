def zamena_zero(S, K):
    max_one_count = 0  # Максимальное значение единиц
    zero_count = 0     # Количество нулей в текущем окне
    left = 0           # Левая граница окна
    
    for right in range(len(S)):
        if S[right] == '0':
            zero_count += 1  # Увеличиваем счетчик нулей
        
        # Если нулей стало больше K, сдвигаем левую границу
        while zero_count > K:
            if S[left] == '0':
                zero_count -= 1
            left += 1
        
        # Обновляем максимальную длину последовательности
        max_one_count = max(max_one_count, right - left + 1)
    
    return max_one_count

def check_binary(S):
    for char in S:
        if char not in ('0', '1'):
            print("Строка бинарная и должна состоять только из 0 и 1")
            exit(0)

# Основной код программы
S = input("Введите бинарную строку: ")
check_binary(S)
    
K = int(input("Введите число K: "))
if K < 0:
    print("Данное число не может быть меньше 0")
    exit(0)
    
result = zamena_zero(S, K)
print(f"Максимальная длина последовательности единиц: {result}")
