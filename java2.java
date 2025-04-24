import java.util.Scanner;

public class Main {

    // функция замены нулей на единицы
    public static int zamenaZero(String S, int K) {
        int maxOneCount = 0;  // Максимальное значение единиц
        int zeroCount = 0;    // кол-во нулей в числе
        int j = 0;           // счетчик кол-ва нулей, которые можем заменить на 1
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                zeroCount++;  // считаем кол-во нулей в строке
            }
            while (zeroCount > K) {
                if (S.charAt(j) == '0') {
                    zeroCount--;  // убираем из общего кол-ва нулей те, которые вышли за диапозон К
                }
                j++;  // считаем те нули, которые не можем заменить на единицы
            }
            maxOneCount = Math.max(maxOneCount, i - j + 1); // поиск максимума
        }
        return maxOneCount;
    }

    public static void bags(String S) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '0' && S.charAt(i) != '1') {
                System.out.println("Строка бинарная и должна состоять только из 0 и 1");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите бинарную строку: ");
        String S = scanner.nextLine();
        bags(S);
        System.out.print("Введите число K: ");
        int K = scanner.nextInt();
        if (K < 0) {
            System.out.println("Данное число не может быть меньше 0");
            System.exit(0);
        }
        int result = zamenaZero(S, K);
        System.out.println("Максимальная длина последовательности единиц: " + result);
    }
}
