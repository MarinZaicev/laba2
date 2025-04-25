using System;

class Program
{
    static int Pozition(int N)
    {
        int pozition = -1;
        int number;
        int pozitionCount = 0;
        int newN = N;
        
        while (newN > 0)
        {
            pozition++;
            number = newN % 10;
            newN = newN / 10;
            if (pozition % 2 != 0 && number % 2 != 0)
            {
                pozitionCount++;
            }
        }
        
        if ((pozitionCount == (pozition + 1) / 2) && (pozition > 0))
        {
            return N;
        }
        else
        {
            return 0;
        }
    }

    static void Main(string[] args)
    {
        Console.WriteLine("Сколько чисел вы планируете вводить?");
        int numberCount = int.Parse(Console.ReadLine());
        
        Console.WriteLine("Вводите числа");
        int number;
        int sum = 0;
        
        for (int i = numberCount; i > 0; i--)
        {
            number = int.Parse(Console.ReadLine());
            sum += Pozition(number);
        }
        
        Console.WriteLine(sum);
    }
}
