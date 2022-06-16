#include <iostream>
using namespace std;

int main() {
	auto pi = 3.14;
	auto calc = [pi](int r)->auto {return pi * r * r; };
	cout << "면적은 " << calc(3) << "이다." << endl;
}