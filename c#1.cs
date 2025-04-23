using System;
using System.Collections.Generic;

class Program
{
    static int Flowers(List<int> waterCount, int volume)
    {
        int x = volume; // объем лейки
        int steps = 0;  // кол-во шагов
        
        for (int i = 0; i < waterCount.Count; i++)
        {
            if (x - waterCount[i] >= 0) // если воды достаточно
            {
                x -= waterCount[i];
                steps++;
            }
            else // если воды недостаточно
            {
                x = volume; // набираем лейку у реки
                steps += 2 * (i + 1) - 1; // шаги до реки и обратно
                x -= waterCount[i];
            }
        }
        
        return steps;
    }

    static void Bags(int flowerCount) // проверка входящих значений
    {
        if (flowerCount < 0)
        {
            Console.WriteLine("Введено невозможное значение");
            Environment.Exit(0); // завершаем программу при ошибке
        }
    }

    static void Main()
    {
        Console.OutputEncoding = System.Text.Encoding.UTF8; // поддержка кириллицы
        
        int flowersCount;
        Console.Write("Введите количество цветов: ");
        flowersCount = int.Parse(Console.ReadLine());
        Bags(flowersCount);

        List<int> waterCounts = new List<int>(flowersCount);
        Console.WriteLine("Введите кол-во воды, нужное для каждого цветка:");

        for (int i = 0; i < flowersCount; i++)
        {
            Console.Write($"{i + 1} цветок: ");
            int water = int.Parse(Console.ReadLine());
            Bags(water);
            waterCounts.Add(water);
        }

        Console.Write("Введите объем лейки: ");
        int volume = int.Parse(Console.ReadLine());
        Bags(volume);

        int steps = Flowers(waterCounts, volume);
        Console.WriteLine($"{steps} шагов вы сделаете");
    }
}
