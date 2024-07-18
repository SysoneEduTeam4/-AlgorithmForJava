#include<iostream>
using namespace std;

int arr[2187][2187];
int result[3];

void solve(int x, int y, int n) {
	int first = arr[x][y];
	bool flag = true;

	for (int i = x;i < x + n;i++) {
		for (int j = y;j < y + n;j++) {
			if (arr[i][y] != first) {
				flag = false;
				break;
			}
		}
	}
	if (flag) {
		result[first + 1]++;
	}
	else {
		for (int a = x;a < x + n;a += n / 3) {
			for (int b = y;b < y + n;b += n / 3) {
				solve(a, b, n / 3);
			}
		}
	}
}

int main() {
	int N;
	cin >> N;
	int x;
	for (int i = 0;i < N;i++) {
		for (int j = 0;j < N;j++) {
			cin >> arr[i][j];
		}
	}
	solve(0, 0, N);
	for (int i = 0;i < 3;i++) {
		cout << result[i] << '\n';
	}
}