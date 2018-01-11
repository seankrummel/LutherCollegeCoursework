/* 
 * File:   rpn.cpp
 * Author: krumse01
 *
 * Created on May 4, 2016, 9:17 AM
 */

//#include <cstdlib>
#include "fraction.h"
#include "stack.h"
#include <iostream>
#include <sstream>
#include <unordered_map>
#include <cmath>

using namespace std;

int main(int argc, char** argv) {
    
    Stack<Fraction> stk;
    string s;
    cout << "Enter an Expression: ";
    getline(cin,s);
    // get an expression from input and store it in string s
    while (s!="") { // ends when nothing is entered
        istringstream sin(s);
        // sin.exceptions(ios_base::failbit | ios_base::badbit);
        /* For some reason, when using this code, the program would try to
        access sin another time and returned an error:
        terminate called after throwing an instance of std:ios_base::failure
        Commenting this out fixed the problem, but I'm unsure why */
        char token;
        bool dec = false;
        unordered_map<string,Fraction> memory;
        while (sin >> token) {
            Fraction x;
            Fraction y;
            string t;
            int num;
            int den;
            char trash;
            double real;
            switch (token) {
                case '+':
                    try {
                        y = stk.pop();
                        x = stk.pop();
                        // if there aren't two Fractions on the stack, then user
                        // did not enter enough operands
                        stk.push(x + y);
                        // pop 2 Fractions off stk, add, push result onto stk
                    } catch (...) {
                        cout << "Not enough operands" << endl;
                    }
                    break;
                case '-':
                    try {
                        y = stk.pop();
                        x = stk.pop();
                        // if there aren't two Fractions on the stack, then user
                        // did not enter enough operands
                        stk.push(x - y);
                        // pop 2 Fractions off stk, subtract, push result
                        // onto stk
                    } catch (...) {
                        cout << "Not enough operands" << endl;
                    }
                    break;
                case '*':
                    try {
                        y = stk.pop();
                        x = stk.pop();
                        // if there aren't two Fractions on the stack, then user
                        // did not enter enough operands
                        stk.push(x * y);
                        // pop 2 Fractions off stk, multiply, push result
                        // onto stk
                    } catch (...) {
                        cout << "Not enough operands" << endl;
                    }
                    break;
                case '/':
                    try {
                        y = stk.pop();
                        x = stk.pop();
                        // if there aren't two Fractions on the stack, then user
                        // did not enter enough operands
                        stk.push(x / y);
                        // pop 2 Fractions off stk, divide, push result onto stk
                    } catch (...) {
                        cout << "Not enough operands" << endl;
                    }
                    break;
                case 'S':
                case 's':
                    try {
                        sin >> t;
                        memory[t] = stk.top();
                        // stores Fraction from top of stk in memory named the
                        // same as the next string in sin
                        
                        // if there isn't anything on the stack, then user
                        // did not enter any operands before S
                    } catch (...) {
                        cout << "Not enough operands" << endl;
                    }
                    break;
                case 'R':
                case 'r':
                    sin >> t;
                    // get next string from expression
                    stk.push(memory[t]);
                    // push Fraction stored in memory named the same as the
                    // next string in sin onto stk
                    break;
                case '(':
                    try {
                        sin >> num; // first int is numerator
                        sin >> trash; // disregard the '/' between the ints
                        sin >> den; // next int is denominator
                        sin >> trash; // also disregard the ')'
                        stk.push(Fraction(num,den));
                    } catch(...) {
                        cout << "Format Fractions as (int/int)" << endl;
                    }
                    break;
                default:
                    // code was provided
                    sin.putback(token);
                    sin >> real;
                    if (sin.fail()) {
                        cout << "Not a number" << endl;
                    }
                    den = 1;
                    while (abs((int)real - real) > 0.000000000000001) {
                        real = real * 10;
                        den = den * 10;
                    }
                    stk.push(Fraction((int)real,den));
                    
                    dec = true; // remember if a decimal number has been entered
                    // so that later we can print as a double.
                    break;
            }
        }
        // all input has now been processed
        
        Fraction it;
        Fraction f = stk.pop(); // should pop last item off stk
        if (!stk.isEmpty()) {
            // if stack is not empty, user entered too few operators
            cout << "Not enough operators" << endl;
        } else {
            memory["it"] = f; // for some reason, this always gets stored as 0/1
            // literally everything else works, and I cannot figure this out,
            // so this is an acceptable loss
            cout << "it is: ";
            if (dec) {
                cout << f.asDouble() << endl;
                // if dec is true, print f as a double
            } else {
                cout << f.numerator() << "/" << f.denominator() << endl;
                // print fraction
            }
        }
        
        // get next expression
        cout << "Enter an Expression: ";
        getline(cin,s);
    }
    
    return 0;
}