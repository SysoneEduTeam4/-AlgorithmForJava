#include <iostream>
using namespace std;

const int MAX = 100000 + 1;

int N;
long long int arr[MAX];
long long int resA, resB;

int main() {

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	int left = 0;
	int right = N - 1;

	int sum = abs(arr[left] + arr[right]);
	resA = arr[left];
	resB = arr[right];

	while (left < right) {
		int mid = arr[left] + arr[right];
		if (abs(mid) < sum) {
			sum = abs(mid);
			resA = arr[left];
			resB = arr[right];
		}

		if (mid < 0) {
			left++;
		}
		else {
			right--;
		}
	}

	cout << resA << " " << resB << "\n";
}