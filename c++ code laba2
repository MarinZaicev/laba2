#include <iostream>
#include <vector>
#include <string>
#include <stdlib.h>
using namespace std;

int flovers(vector<int>waterCount, int volume) {
    int x = volume; // объем лейки
    int steps = 0; // кол-во шагов
    for (int i = 0; i < waterCount.size() ; i ++){
        if (x - waterCount[i] >= 0) {  // если воды для полива цветка достаточно
            x -= waterCount[i]; 
            steps++;
        }
        else if (x - waterCount[i] < 0) { // еслт воды для полива цветка недостаточно
            x = volume; // набираем лейку у реки
            steps += 2*(i + 1) - 1; // прибавляем кол-во шагов от цветка до реки и обратно.
            x -= waterCount[i];
        }
    }
    return steps;
}

int bags(int flovercount) { // проверяем входящие значения
    if (flovercount < 0) {
        cout << "введено невозможное значение";
        exit(0); // если входящее число не удовлетворяет условию, завершаем выполнение программы
    }
    return 1;
}

int main() {
    setlocale(LC_ALL, "RUSSIAN");
    int floversCount; // кол-во цветов
    cout << "Введите количество цветов: ";
    cin >> floversCount;
    bags(floversCount);
    vector<int> vecWaterCount (floversCount); // вектор для хранения потребностей цветов
    int waterCount; // кол-во воды для  полива цветов
    cout << "Введите кол-во воды, нужное для каждого цветка " << endl;
    for (int i = 0; i < floversCount; i++) {
        cout << i + 1 << " цветок ", cin >> waterCount; // вводим кол-во воды для каждого цветка
        bags(waterCount);
        vecWaterCount[i] = waterCount;
    }
    cout << "Введите объем лейки: ";
    int volume; // объем лейки
    cin >> volume;
    bags(volume);
    int steps = flovers(vecWaterCount, volume);
    
    cout << steps << " шагов вы сделаете" << endl;
    
}
