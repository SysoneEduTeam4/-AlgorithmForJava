#include<iostream>
#include<string>
using namespace std;
int arr[64][64];
int result[3];

void solve(int x, int y, int n) {
	if (n == 1) {
		cout << arr[x][y];
		return;
	}
	bool one = true;
	bool zero = true;
	for (int i = x; i < x + n; i++) {
		for (int j = y; j < y + n; j++) {
			if (arr[i][j] == 1) {
				zero = false;
			}
			if (arr[i][j] == 0) {
				one = false;
			}
		}
	}
	if (one == true) {
		cout << 1;
		return;
	}
	if (zero == true) {
		cout << 0;
		return;
	}
	cout << "(";
	solve(x, y, n / 2);
	solve(x, y + n / 2, n / 2);
	solve(x + n / 2, y, n / 2);
	solve(x + n / 2, y + n / 2, n / 2);
	cout << ")";

}
int main() {
	int N;
	cin >> N;
	int x;
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < N; j++) {
			arr[i][j] = s[j] - '0';
		}
	}
	solve(0, 0, N);


}