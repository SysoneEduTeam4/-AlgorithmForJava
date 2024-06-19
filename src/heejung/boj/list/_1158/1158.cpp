#include<iostream>
#include<list>
using namespace std;

int main() {
	int n, k;
	cin >> n >> k;
	list<int> li;
	for (int i = 1;i <= n;i++) {
		li.push_back(i);
	}
	cout << "<";
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < k - 1;j++) {
			li.push_back(li.front());
			li.pop_front();
		}
		cout << li.front();
		if (i != n - 1)
			cout << ", ";
		li.pop_front();
	}
	cout << ">";
	return 0;
}