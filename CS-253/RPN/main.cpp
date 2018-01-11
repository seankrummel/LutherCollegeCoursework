/* 
 * File:   main.cpp
 * Author: krumse01
 *
 * Created on April 15, 2016, 12:40 PM
 */

#include <cstdlib>
#include <vector>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

int main(int argc, char** argv) {
    vector<int> vec;
    int memory;
    
    for (int i=1;i<argc;i++) {
        string s = argv[i];
        if (s == "+") {
            int arg2 = vec.back();
            vec.pop_back();
            int arg1 = vec.back();
            vec.pop_back();
            vec.push_back(arg1 + arg2);
        }
        else if (s == "-") {
            int arg2 = vec.back();
            vec.pop_back();
            int arg1 = vec.back();
            vec.pop_back();
            vec.push_back(arg1 - arg2);
        }
        else if (s == "*") {
            int arg2 = vec.back();
            vec.pop_back();
            int arg1 = vec.back();
            vec.pop_back();
            vec.push_back(arg1 * arg2);
        }
        else if (s == "/") {
            int arg2 = vec.back();
            vec.pop_back();
            int arg1 = vec.back();
            vec.pop_back();
            vec.push_back(arg1 / arg2);
        }
        else if (s == "S" || s == "s") {
            memory = vec.back();
        }
        else if (s == "R" || s == "r") {
            vec.push_back(memory);
        }
        else {
            int x;
            stringstream sin(s);
            sin >> x;
            vec.push_back(x);
        }
    }
    
    cout << vec.back() << endl;
    
    return 0;
}

