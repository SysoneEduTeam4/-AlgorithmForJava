#include<iostream>
#include<stack>
using namespace std;

int main() {
	int tc;
	cin >> tc;
	int cnt = 0;
	for (int i = 0;i < tc;i++) {
		string str;
		cin >> str;
		stack<char> s;
		for (int i = 0;i < str.size();i++) {
			if (s.empty())
				s.push(str[i]);
			else if (s.top() == str[i]) {
				
				s.pop();
			}
			else
				s.push(str[i]);

		}
		if (s.empty())
			cnt++;
	}
	cout << cnt << endl;
	return 0;
}