#include <iostream>

using namespace std;
#define MAX 9

int N, M;
int arr[MAX];
bool visited[MAX] = { 0, };

void dfs(int k) { 
    if (k == M) { 
        for (int i = 0;i < M;i++)
            cout << arr[i] << " "; 
        cout << "\n";
 
    }
    else { 
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			for (int j = 1; j <= i; j++) {
				visited[j] = true;
			}
			arr[k] = i;
			dfs(k + 1);
			for (int k = 1; k < 9; k++) {
				visited[k] = false;
			}
		}
    }
}

int main() {
    cin >> N >> M;
    dfs(0);
}