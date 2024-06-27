#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {

	int n;
	cin >> n;
	
	vector<int> vec;
	for (int i = 0;i < n;i++) {
		int a;
		cin >> a;

		vec.push_back(a);
	}
	sort(vec.begin(), vec.end());

	// 1 2 3 5 7 9 10 11 12
	int answer ;
	cin >> answer;
	int cnt = 0;
	int second_start = vec.size() - 1;
	for (int i = 0;i < vec.size();i++) {
		for (int j = second_start;j > i;j--) {
			if (vec[i] + vec[j] == answer) {
			//	cout << vec[i] << " " << vec[j] << endl;
				cnt++;
				second_start = j;
				break;
			}
		
		}

		
	
	}
	cout << cnt << endl;


	return 0;
}