using System;

class Program
{
    static int pozition(int N)
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

    static void bags(int tryNumber)
    {
        if (tryNumber < 0)
        {
            Console.WriteLine("вводите только положительное число");
            Environment.Exit(0);
        }
    }

    static void Main(string[] args)
    {
        Console.OutputEncoding = System.Text.Encoding.UTF8;
        Console.WriteLine("сколько чисел вы планируете вводить?");
        int numberCount;
        numberCount = Convert.ToInt32(Console.ReadLine());
        bags(numberCount);
        
        Console.WriteLine("вводите числа ");
        int number;
        int sum = 0;
        
        for (int i = numberCount; i > 0; i--)
        {
            number = Convert.ToInt32(Console.ReadLine());
            bags(number);
            sum += pozition(number);
        }
        
        Console.WriteLine(sum);
    }
}
