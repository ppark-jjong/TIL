#include <iostream>
using namespace std;

class Calculator {
public:
	virtual int add(int a, int b) = 0;
	virtual int subtract(int a, int b) = 0;
	virtual double average(int a[], int size) = 0;
};

class GoodCalc :public Calculator {
	virtual int add(int a, int b) {
		int result = a + b;
		return result;
	}
	virtual int subtract(int a, int b) {
		return a - b;
	}
	virtual double average(int a[], int size) {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += a[i];
		}
		return sum / size;
	}
};

int main() {

}