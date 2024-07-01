#include<iostream>
#include<list>

using namespace std;
int min(int a, int b) {
	if (a < b) return a;
	else
		return b;

}
int main() {
	int n, m;
	list<int> que;
	int cnt = 0;
	cin >> n >> m;
	for (int i = 1;i <= n;i++) {
		que.push_back(i);
	}
	for (int i = 0;i < m;i++) {
		int a;
		cin >> a;
		if (que.front() == a)
		{
			que.pop_front();
		}
		else {
			
			int compare = 0;
				while (!que.empty()) {
					if (que.front() != a)
					{
						int front = que.front();
						que.pop_front();
						que.push_back(front);
						compare++;
					}
					else {
						cnt+=min(compare, que.size() - compare);
						que.pop_front();
						break;

					}
				}
			
			
		}
	}
	cout << cnt << endl;
	return 0;
}