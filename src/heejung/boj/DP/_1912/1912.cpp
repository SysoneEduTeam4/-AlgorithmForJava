#include<iostream>
#include<vector>
using namespace std;

int maxfun(int a, int b) {
	if (a > b) 
		return a;
	
	else
		return b;
}

int main() {
	int c;
	cin >> c;
	vector<int> vec;
	for (int i = 0;i < c;i++) {
		int t;
		cin >> t;
		vec.push_back(t);
	}
	int max = -1000;
	int sum = 0;

	for (int i = 0;i < c;i++) {
		if (vec[i] > sum + vec[i]) {
			sum = vec[i];
			max = maxfun(sum, max);
		}
		else {
			sum += vec[i];
			max = maxfun(sum, max);
		}
	}
	cout << max <<"\n";
}