import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static int flovers(ArrayList<Integer> waterCount, int volume) {
        int x = volume; // объем лейки
        int steps = 0; // кол-во шагов
        for (int i = 0; i < waterCount.size(); i++) {
            if (x - waterCount.get(i) >= 0) {  // если воды для полива цветка достаточно
                x -= waterCount.get(i); 
                steps++;
            }
            else if (x - waterCount.get(i) < 0) { // если воды для полива цветка недостаточно
                x = volume; // набираем лейку у реки
                steps += 2*(i + 1) - 1; // прибавляем кол-во шагов от цветка до реки и обратно
                x -= waterCount.get(i);
            }
        }
        return steps;
    }
    
    public static void bags(int flowerCount) { // проверяем входящие значения
        if (flowerCount < 0) {
            System.out.println("Введено невозможное значение");
            System.exit(0); // если входящее число не удовлетворяет условию, завершаем выполнение программы
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество цветов: ");
        int flowersCount = scanner.nextInt();
        bags(flowersCount);
        
        ArrayList<Integer> vecWaterCount = new ArrayList<>(flowersCount); // список для хранения потребностей цветов
        
        System.out.println("Введите кол-во воды, нужное для каждого цветка:");
        for (int i = 0; i < flowersCount; i++) {
            System.out.print((i + 1) + " цветок: ");
            int waterCount = scanner.nextInt();
            bags(waterCount);
            vecWaterCount.add(waterCount);
        }
        
        System.out.print("Введите объем лейки: ");
        int volume = scanner.nextInt();
        bags(volume);
        
        int steps = flovers(vecWaterCount, volume);
        System.out.println(steps + " шагов вы сделаете");
        
        scanner.close();
    }
}
