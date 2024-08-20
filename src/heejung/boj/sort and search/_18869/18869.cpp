#include<iostream>
#include<algorithm>
using namespace std;

pair<int, int> u[101][10010];


bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	return a.second < b.second;
}
int main() {
	int x, y;
	cin >> x >> y;
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			int input;
			cin >> input;
			u[i][j] = { j,input };
		}
	}
	for (int i = 0; i < x; i++) {
		sort(u[i], u[i] + y, compare);
	}

	int result = 0;

	for (int i = 0; i < x - 1; i++) {
		for (int j = i + 1; j < x; j++) {
			bool equal = true;
			for (int k = 0; k < y; k++) {
				if (u[i][k].first != u[j][k].first) {
					equal = false;
					break;
				}
				else {
					if (i != y - 1) {
						if (u[i][k].second < u[i][k + 1].second != u[j][k].second < u[j][k + 1].second) {
							equal = false;
							break;
						}
					}
				}

			}
			if (equal) result++;
		}
	}

	cout << result << '\n';
}