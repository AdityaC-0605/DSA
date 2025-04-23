#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1 || s.size() <= numRows) return s;

        vector<string> rows(min(numRows, int(s.size())));
        int currRow = 0;
        bool goingDown = false;

        for (char c : s) {
            rows[currRow] += c;
            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown;
            currRow += goingDown ? 1 : -1;
        }

        string result;
        for (string row : rows) result += row;
        return result;
    }
};

int main() {
    Solution sol;
    string input = "PAYPALISHIRING";
    int numRows = 3;
    cout << sol.convert(input, numRows) << endl;
    return 0;
}