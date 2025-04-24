using System;

class Program
{
    // Функция замены нулей на единицы
    static int ZamenaZero(string S, int K)
    {
        int maxOneCount = 0;  // Максимальное значение единиц
        int zeroCount = 0;    // Количество нулей в текущем окне
        int j = 0;            // Левая граница окна
        
        for (int i = 0; i < S.Length; i++)
        {
            if (S[i] == '0')
            {
                zeroCount++;  // Увеличиваем счетчик нулей
            }
            
            // Если нулей стало больше K, сдвигаем левую границу
            while (zeroCount > K)
            {
                if (S[j] == '0')
                {
                    zeroCount--;  // Уменьшаем счетчик нулей
                }
                j++;
            }
            
            // Обновляем максимальную длину последовательности
            maxOneCount = Math.Max(maxOneCount, i - j + 1);
        }
        
        return maxOneCount;
    }

    // Проверка, что строка бинарная
    static void CheckBinary(string S)
    {
        foreach (char c in S)
        {
            if (c != '0' && c != '1')
            {
                Console.WriteLine("Строка бинарная и должна состоять только из 0 и 1");
                Environment.Exit(0);
            }
        }
    }

    static void Main()
    {
        Console.OutputEncoding = System.Text.Encoding.UTF8;
        
        Console.Write("Введите бинарную строку: ");
        string S = Console.ReadLine();
        CheckBinary(S);
        
        Console.Write("Введите число K: ");
        int K;
        if (!int.TryParse(Console.ReadLine(), out K) || K < 0)
        {
            Console.WriteLine("Данное число не может быть меньше 0");
            Environment.Exit(0);
        }
        
        int result = ZamenaZero(S, K);
        Console.WriteLine($"Максимальная длина последовательности единиц: {result}");
    }
}
