#include<iostream>
#include<list>
using namespace std;

int main() {
	int tc;
	cin >> tc;

	for (int i = 0;i < tc;i++) {
		string str;
		cin >> str;
		list <char> a;
		auto point = a.begin();
	
		for (int i = 0;i < str.size();i++) {
			if (str[i] == '<') {
				if (point != a.begin()) {
					point--;
				}
				
			}
			else if (str[i] == '>') {
				if (point != a.end())
					point++;
				
			}
			else if (str[i] == '-') {
				if (point != a.begin())
				{
					point--;
					point = a.erase(point);
				}
			}
			else {
				a.insert(point, str[i]);
			}
		}
		for (auto c : a)cout << c;
		cout << endl;

	}

	return 0;

}