#include<iostream>
using namespace std;
int main() {
	long long arr[91][2] = { {0,0},{0,1},{1,0} };

	int n;
	cin >> n;

	int sum = 0;
	for (int i = 2; i <= n; i++)
	{
		arr[i][0] = arr[i - 1][0] + arr[i - 1][1];
		arr[i][1] = arr[i - 1][0];




	}
	cout << arr[n][0] + arr[n][1] << "\n";
	return 0;
}