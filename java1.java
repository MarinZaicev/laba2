import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static int flowers(ArrayList<Integer> waterCount, int volume) {
        int x = volume; // объем лейки
        int steps = 0;  // кол-во шагов
        
        for (int i = 0; i < waterCount.size(); i++) {
            if (x - waterCount.get(i) >= 0) {  // если воды достаточно
                x -= waterCount.get(i);
                steps++;
            } else {  // если воды недостаточно
                x = volume; // набираем лейку у реки
                steps += 2 * (i + 1) - 1; // шаги до реки и обратно
                x -= waterCount.get(i);
            }
        }
        
        return steps;
    }import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static int flowers(ArrayList<Integer> waterCount, int volume) {
        int x = volume; // объем лейки
        int steps = 0;  // кол-во шагов
        
        for (int i = 0; i < waterCount.size(); i++) {
            if (x - waterCount.get(i) >= 0) {  // если воды достаточно
                x -= waterCount.get(i);
                steps++;
            } else {  // если воды недостаточно
                x = volume; // набираем лейку у реки
                steps += 2 * (i + 1) - 1; // шаги до реки и обратно
                x -= waterCount.get(i);
            }
        }
        
        return steps;
    }

    public static void bags(int flowerCount) { // проверка входящих значений
        if (flowerCount < 0) {
            System.out.println("Введено невозможное значение");
            System.exit(0); // завершаем программу при ошибке
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество цветов: ");
        int flowersCount = scanner.nextInt();
        bags(flowersCount);

        ArrayList<Integer> waterCounts = new ArrayList<>(flowersCount);
        System.out.println("Введите кол-во воды, нужное для каждого цветка:");

        for (int i = 0; i < flowersCount; i++) {
            System.out.print((i + 1) + " цветок: ");
            int water = scanner.nextInt();
            bags(water);
            waterCounts.add(water);
        }

        System.out.print("Введите объем лейки: ");
        int volume = scanner.nextInt();
        bags(volume);

        int steps = flowers(waterCounts, volume);
        System.out.println(steps + " шагов вы сделаете");
        
        scanner.close();
    }
}

    public static void bags(int flowerCount) { // проверка входящих значений
        if (flowerCount < 0) {
            System.out.println("Введено невозможное значение");
            System.exit(0); // завершаем программу при ошибке
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество цветов: ");
        int flowersCount = scanner.nextInt();
        bags(flowersCount);

        ArrayList<Integer> waterCounts = new ArrayList<>(flowersCount);
        System.out.println("Введите кол-во воды, нужное для каждого цветка:");

        for (int i = 0; i < flowersCount; i++) {
            System.out.print((i + 1) + " цветок: ");
            int water = scanner.nextInt();
            bags(water);
            waterCounts.add(water);
        }

        System.out.print("Введите объем лейки: ");
        int volume = scanner.nextInt();
        bags(volume);

        int steps = flowers(waterCounts, volume);
        System.out.println(steps + " шагов вы сделаете");
        
        scanner.close();
    }
}
