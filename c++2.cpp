#include <iostream>
#include <vector>
#include <string>
using namespace std;

int zamenaZero(string S, int K) {  // функция замены нулей на единицы
    int maxOneCount = 0;  // Максимальное значение единиц
    int zeroCount = 0;   // кол-во нулей в числе
    int j = 0;     //счетчик кол-ва нулей, которые можем заменить на 1
    for (int i = 0; i < S.size(); i++) {
        if (S[i] == '0') {
            zeroCount++;  //считаем кол-во нулей в строке
        }
        while (zeroCount > K) {
            if (S[j] == '0') {
                zeroCount--;  //убираем из общего кол-ва нулей те, которые вышли за диапозон К
            }
            j++;  // считаем те нули, которые не можем заменить на единицы
        }
        maxOneCount = max(maxOneCount, i - j + 1); //поиск 
    }
    return maxOneCount;
}

int bags(string S) {
    for (int i = 0; i < S.size(); i++) {
        if (S[i] != '0' && S[i] != '1') {
            cout << "Строка бинарная и должна состоять только из 0 и 1";
            exit(0);
        }
    }
}

int main() {
    setlocale(LC_ALL, "Russian");
    string S;
    cout << "Введите бинарную строку: ";
    cin >> S;
    bags(S);
    int K;
    cout << "Введите число K: ";
    cin >> K;
    if(K < 0) {
        cout << "Данное число не может быть меньше 0";
        exit(0);
    }
    int result = zamenaZero(S, K);
    cout << "Максимальная длина последовательности единиц: " << result << endl;
    return 0;
}
