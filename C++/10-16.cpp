#include <iostream>
using namespace std;

int main() {
	auto love = [](string a, string b) {
		cout << a << "º¸´Ù " << b << "°¡ ÁÁ¾Æ" << endl;
	};
	love("µ·", "³Ê");
	love("³Ã¸é", "µ·±î½º");

}