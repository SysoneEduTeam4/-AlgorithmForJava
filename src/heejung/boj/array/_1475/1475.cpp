#include<iostream>
#include<string>
#include<typeinfo>
using namespace std;

int main() {
    string str;
    cin >> str;

    int arr[10] = { 0 };

    for (int i = 0;i < str.size();i++) {
        if (str[i] == '9'||str[i]=='6') {
        
            if (arr[6] == arr[9]) {
                arr[6]++;
            }
            else
                arr[9]++;

        }
        else {
            
            char s = str[i];

            int ii = s-48;

     
           
       arr[ii] += 1;
    }
    }
   
    int max = 0;
    for (int i = 1;i <=9;i++) {
        if (max < arr[i]) {
      
                max = arr[i];
        }
    }

    cout << max << endl;
    return 0;
}