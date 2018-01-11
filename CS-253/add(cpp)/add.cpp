/* 
 * File:   main.cpp
 * Author: krumse01
 *
 * Created on April 14, 2016, 8:27 PM
 */

#include <cstdlib>
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main(int argc, char** argv) {
    int sum = 0;
    for (int i=1;i<argc;i++) {
        stringstream sin(argv[i]);
        int x;
        sin >> x;
        sum += x;
    }
    cout << sum << endl;
    
    return 0;
}

