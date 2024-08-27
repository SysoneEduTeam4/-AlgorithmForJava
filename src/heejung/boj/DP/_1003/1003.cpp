#include<iostream>
#include<vector>
using namespace	std;

int arr[40];
int zero = 0, one = 0;
int fibonacci(int n) {
    if (n == 0) {
        zero = zero + 1;
        return 0;
    }
    else if (n == 1) {
        one = one + 1;
        return 1;
    }
    else {
        int x = n - 1;
        int y = n - 2;
        return fibonacci(x) + fibonacci(y);
    }
}

int main() {
    int t;
    cin >> t;
    vector<pair<int, int>> result;
    result.push_back({ 1,0 }); //0 »ğÀÔ
    result.push_back({ 0,1 });//1 »ğÀÔ
    for (int i = 0;i < t;i++) {
        cin >> arr[i];

    }

    for (int i = 0;i < t;i++) {
        if(arr[i]>result.size()-1) {
            for (int j = result.size();j <= arr[i];j++) {
                result.push_back({ result[j - 1].first + result[j - 2].first,result[j - 1].second + result[j - 2].second });
            }
        }

        cout << result[arr[i]].first<<" "<<result[arr[i]].second << "\n";

    }
}