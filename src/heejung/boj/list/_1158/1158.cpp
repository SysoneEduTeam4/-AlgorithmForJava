#include<iostream>
#include<queue>
using namespace std;
int main() {
	queue<int> q1;

	int x, y;
	cin >> x >> y;
	for (int i = 1; i <= x; i++) {
		q1.push(i);
	}
	cout << "<";
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y - 1; j++) {
			q1.push(q1.front());
			q1.pop();

		}
		cout << q1.front();
		if (i != x - 1) {
			cout << ", ";
		}
		q1.pop();
	}
	cout << ">";

}