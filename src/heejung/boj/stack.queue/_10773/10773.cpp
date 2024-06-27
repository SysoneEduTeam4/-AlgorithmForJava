#include<iostream>
#include<stack>
using namespace std;

int main() {
	int a;
	cin >> a; 
	stack<int> stk; //stack 생성
	for (int i = 0;i < a;i++) {
		int input;
		cin >> input;
		if (input == 0) {
			if (!stk.empty()) {
				stk.pop(); // input이 0이면 stack의 top 제게
			}
		}
		else {
			stk.push(input); //input이 0이 아니면 stack에 값 push
		}
	}
	int cnt = 0;
	while (!stk.empty()) {
		cnt += stk.top(); //stack에 남아있는 값 더해줌
		stk.pop();
	}

	cout << cnt << endl; 

}