import java.util.Scanner;

public class Main {
    
    static int pozition(int N) {
        int pozition = -1;
        int number;
        int pozitionCount = 0;
        int newN = N;
        
        while (newN > 0) {
            pozition++;
            number = newN % 10;
            newN = newN / 10;
            if (pozition % 2 != 0 && number % 2 != 0) {
                pozitionCount++;
            }
        }
        
        if ((pozitionCount == (pozition + 1) / 2) && (pozition > 0)) {
            return N;
        } else {
            return 0;
        }
    }
    
    static void bags(int tryNumber) {
        if (tryNumber < 0) {
            System.out.println("вводите только положительное число");
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("сколько чисел вы планируете вводить?");
        int numberCount = scanner.nextInt();
        bags(numberCount);
        
        System.out.println("вводите числа ");
        int number;
        int sum = 0;
        
        for (int i = numberCount; i > 0; i--) {
            number = scanner.nextInt();
            bags(number);
            sum += pozition(number);
        }
        
        System.out.println(sum);
    }
}
