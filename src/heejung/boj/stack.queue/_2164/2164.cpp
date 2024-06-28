#include<iostream>
#include<list>
using namespace std;

int main() {
	int a;
	cin >> a;
	list<int> li;
	for (int i = 1;i <= a;i++) {
		li.push_back(i);
	}
	int cnt = 0;
	while (li.size()>1) {
		if (cnt % 2 == 0) {
			li.pop_front();
			cnt++;
		}
		else {
			li.push_back(li.front());
			li.pop_front();
			cnt++;
		}
	}
	cout << li.front();
}