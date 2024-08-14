#include<iostream>
using namespace std;

int arr[128][128];
int answer[2];

void sol(int x, int y, int k)
{
	int start = arr[x][y];
	bool flag = true;
	for (int i = x;i < x+k;i++) {
		for (int j = y;j < y+k;j++) {
			if (arr[i][j] != start) {
				flag = false;
				break;
			}
		}
	}
	if(flag)
		answer[start]++;
	else {
		for (int a = x;a < x + k;a += k/ 2) {
			for (int b = y;b < y + k;b += k / 2) {
				sol(a, b, k / 2);
			}
		}
	}
}

int main() {
	int N;
	cin >> N;
	for (int i = 0;i < N;i++) {
		for (int j = 0;j < N;j++) {
			cin >> arr[i][j];
		}
	}
	sol(0, 0, N);
	for (int i = 0;i < 2;i++) {
		cout << answer[i] << '\n';
	}
}