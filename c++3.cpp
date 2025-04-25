#include <iostream>
#include <cmath>
using namespace std;



int pozition(int N){
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
	}
	else {
		return 0;
	}
}
void bags(int tryNumber) {
	if(tryNumber < 0) {
		cout << "вводите только положительное число" << endl;
		exit(0);
	}
}

int main(){
	setlocale(LC_ALL, "Russian");
	cout << "сколько чисел вы планируете вводить?" << endl;
	int numberCount;
	cin >> numberCount;
	bags(numberCount);
	cout << "вводите числа " << endl;
	int number;
	int sum = 0;
	for (int i = numberCount; i > 0; i--) {
		cin >> number;
		bags(number);
		sum += pozition(number);
	}
	cout << sum;
}

