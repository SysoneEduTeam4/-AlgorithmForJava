#include<iostream>
using namespace std;

int main() {
	int result;

	int a, b, c;

	cin >> a >> b >> c;

	result = a * b * c;

	//cout << result << endl;
	int arr[10] = { 0, };
	while (result >0) {
		//cout << result % 10 << " " << result / 10<<endl;
		arr[result % 10]+=1;

		result /= 10;
		

	}

	for (int i = 0;i < 10;i++) {
		cout << arr[i] << endl;
	}
}