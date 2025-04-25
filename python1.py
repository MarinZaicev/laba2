def flowers(water_count, volume):
    x = volume
    steps = 0
    
    for i in range(len(water_count)):
        if x - water_count[i] >= 0:
            x -= water_count[i]
            steps += 1
        else:
            x = volume
            steps += 2 * (i + 1) - 1
            x -= water_count[i]
    return steps

def bags(flower_count):
    if flower_count < 0:
        print("введено невозможное значение")
        exit(0)

# Основной код
user_input = input("Введите количество цветов: ")
if not user_input.isdigit():  # Проверяем, что введено число
    print("Ошибка: введите целое число!")
    exit(1)
flower_count = int(user_input)
bags(flower_count)

water_counts = []
print("Введите кол-во воды, нужное для каждого цветка:")

for i in range(flower_count):
    user_input = input(f"{i+1} цветок: ")
    if not user_input.isdigit():
        print("Ошибка: введите целое число!")
        exit(1)
    water = int(user_input)
    bags(water)
    water_counts.append(water)

user_input = input("Введите объем лейки: ")
if not user_input.isdigit():
    print("Ошибка: введите целое число!")
    exit(1)
volume = int(user_input)
bags(volume)

steps = flowers(water_counts, volume)
print(f"{steps} шагов вы сделаете")
