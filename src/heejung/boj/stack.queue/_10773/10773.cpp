#include<iostream>
#include<stack>
using namespace std;

int main() {
	int a;
	cin >> a; 
	stack<int> stk; //stack ����
	for (int i = 0;i < a;i++) {
		int input;
		cin >> input;
		if (input == 0) {
			if (!stk.empty()) {
				stk.pop(); // input�� 0�̸� stack�� top ����
			}
		}
		else {
			stk.push(input); //input�� 0�� �ƴϸ� stack�� �� push
		}
	}
	int cnt = 0;
	while (!stk.empty()) {
		cnt += stk.top(); //stack�� �����ִ� �� ������
		stk.pop();
	}

	cout << cnt << endl; 

}