#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;


long long result = 0;

int main() {

	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	int N, M;
	cin >> N >> M;


	vector<int> vec;
	for (int i = 0; i < N; i++) {
		int c;
		cin >> c;
		vec.push_back(c);
	}
	sort(vec.begin(), vec.end());
	long long left = 0, right = vec[vec.size()-1];
	long long mid;
	while (left <= right) {
		mid = (left + right) / 2;
		long long now = 0;
		for (int i = 0; i < N; i++)
		{
			long long sub = vec[i] - mid;
			if (sub > 0) {
				now += sub;
			}

		}
		if (now >= M) {
			left = mid + 1;
			result = max(result, mid);
		}
		else
			right = mid - 1;

	}
	cout << result << '\n';


}