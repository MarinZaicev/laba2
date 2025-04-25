def zamena_zero(S, K):
    max_one_count = 0
    zero_count = 0
    left = 0
    
    for right in range(len(S)):
        if S[right] == '0':
            zero_count += 1
        
        while zero_count > K:
            if S[left] == '0':
                zero_count -= 1
            left += 1
        
        max_one_count = max(max_one_count, right - left + 1)
    
    return max_one_count

def check_binary(S):
    for char in S:
        if char not in ('0', '1'):
            print("Ошибка: строка должна содержать только 0 и 1")
            exit(1)

# Ввод данных и выполнение
S = input("Введите бинарную строку: ").strip()
check_binary(S)

try:
    K = int(input("Введите число K: "))
    if K < 0:
        print("Ошибка: число K не может быть отрицательным")
        exit(1)
except ValueError:
    print("Ошибка: введите целое число для K")
    exit(1)

result = zamena_zero(S, K)
print(f"Результат: {result}")
