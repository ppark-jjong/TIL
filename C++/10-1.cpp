#include <iostream>
using namespace std;

class Circle {
	int radius;
public:
	Circle(int radius = 1) {
		this->radius = radius;
	}
	int getRadius() {
		return radius;
	}
};

template <class T>//템플릿을 선언하는 키워드 : template / 제네릭 타입을 선언하는 키워드 : class / 제네릭 타입 선언 : T
void myswap(T& a, T& b){
	T tmp;
	tmp = a;
	a = b;
	b = tmp;
}
int main() {
	int a = 4, b = 5;
	myswap(a, b);
	cout << "a=" << a << ", b=" << b << endl;
	
	double c = 0.3, d = 12.5;
	myswap(c, d);
	cout << "c=" << c << ", d=" << d << endl;
	
	Circle donut(5), pizza(20);
	myswap(donut, pizza);
	cout << "donut=" << donut.getRadius() << ", pizza=" << pizza.getRadius() << endl;
}
