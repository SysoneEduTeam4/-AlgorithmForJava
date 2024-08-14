#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int x, y;
	int answer = 0;
	cin >> x >> y;
	vector<int> vec;
	for (int i = 0;i < y;i++) {
		int c;
		cin >> c;
		vec.push_back(c);
	}

	
	sort(vec.begin(), vec.end());

	int min = 1;
	int max = vec[y - 1];

	while (min <= max) {
		int stand = (min + max) / 2;
		int check = 0;
		for (int i = 0;i < y;i++) {
			check += (vec[i] / stand);
		}
		if (check >= x) {
			min = stand + 1;
			answer = stand;
		}
		else {
			max = stand - 1;
		}
	}

	cout << answer << "\n";
}