def flowers(water_count, volume):
    x = volume  # объем лейки
    steps = 0   # кол-во шагов
    
    for i in range(len(water_count)):
        if x - water_count[i] >= 0:  # если воды достаточно
            x -= water_count[i]
            steps += 1
        else:  # если воды недостаточно
            x = volume  # набираем лейку у реки
            steps += 2 * (i + 1) - 1  # шаги до реки и обратно
            x -= water_count[i]
    
    return steps

def bags(flower_count):  # проверка входящих значений
    if flower_count < 0:
        print("введено невозможное значение")
        exit(0)  # завершаем программу при ошибке

def main():
    try:
        flower_count = int(input("Введите количество цветов: "))
        bags(flower_count)
        
        water_counts = []
        print("Введите кол-во воды, нужное для каждого цветка:")
        
        for i in range(flower_count):
            water = int(input(f"{i+1} цветок: "))
            bags(water)
            water_counts.append(water)
        
        volume = int(input("Введите объем лейки: "))
        bags(volume)
        
        steps = flowers(water_counts, volume)
        print(f"{steps} шагов вы сделаете")
        
    except ValueError:
        print("Ошибка: введите целое число!")
        exit(1)

if __name__ == "__main__":
    main()
