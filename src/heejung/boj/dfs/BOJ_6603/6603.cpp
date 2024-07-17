#include<iostream>
using namespace std;

int k;
int arr[14];

int answer[6];
int visited[14] = { 0, };
void dfs(int x) {
	if (x == 6) {
		for (int i = 0;i < 6;i++) {
			cout << answer[i] << " ";
		}
		cout << "\n";
	}
	else {
		for (int i = 0;i < k;i++) {
			if (visited[i]) continue;;
			for (int j = 0;j <= i;j++) {
				visited[j] = true;
			}
			answer[x] = arr[i];
			dfs(x + 1);
			for (int j = 0;j < k;j++) {
				visited[j] = false;
			}

		}
	}
}


int main() {

	while (true) {
		cin >> k;
		if (k == 0) {
			break;
		}
		else {
			for (int i = 0;i < k;i++) {
				cin >> arr[i];
			}
			dfs(0);
		
			
		}
		cout << "\n";
	}
}