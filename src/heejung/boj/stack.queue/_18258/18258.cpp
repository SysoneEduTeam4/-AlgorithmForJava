#include<iostream>
#include<queue>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	int test_case;
	cin >> test_case;
	queue<int> que; //queue 생성
	for (int i = 0;i < test_case;i++) {
		string str;
		cin >> str;
		if (str == "push") {
			int a;
			cin >> a;
			que.push(a);
		}
		else if (str == "pop") {
			if (que.empty()) {
				cout << -1<<"\n";
			}
			else {
				cout << que.front()<<"\n"; //맨앞에요소 출력
				que.pop();
			}
		}
		else if (str == "size") {
			cout << que.size()<<"\n";
		}
		else if (str == "empty") {
			if (que.empty())
				cout << 1<<"\n";
			else
				cout << 0<<"\n" ;
		}
		else if (str == "front") {
			if (que.empty())
				cout << -1<<"\n" ;
			else
				cout << que.front()<<"\n";
		}
		else if (str == "back") {
			if (que.empty())
				cout << -1<<"\n";
			else
				cout << que.back() <<"\n";
		}
	}
	return 0;
}