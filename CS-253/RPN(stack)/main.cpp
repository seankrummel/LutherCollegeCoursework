/* 
 * File:   main.cpp
 * Author: krumse01
 *
 * Created on April 13, 2016, 7:41 PM
 */

#include <cstdlib>
#include "stack.h"
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main(int argc, char** argv) {
    Stack mys;
    int storage;
    
    for (int i=1;i<argc;i++){
        string s = argv[i];
        
        if (s == "+") {
            int arg2 = mys.pop();
            int arg1 = mys.pop();
            mys.push(arg1 + arg2);
        } 
        else if (s == "-") {
            int arg2 = mys.pop();
            int arg1 = mys.pop();
            mys.push(arg1 - arg2);
        }
        else if (s == "*") {
            int arg2 = mys.pop();
            int arg1 = mys.pop();
            mys.push(arg1 * arg2);
        }
        else if (s == "/") {
            int arg2 = mys.pop();
            int arg1 = mys.pop();
            mys.push(arg1 / arg2);
        }
        else if (s == "S" || s == "s") {
            storage = mys.top();
        }
        else if (s == "R" || s == "R") {
            mys.push(storage);
        }
        else {
            int x;
            stringstream sin(s);
            sin >> x;
            mys.push(x);
        }
    }
    
    cout << mys.pop() << endl;
    
    return 0;
}
