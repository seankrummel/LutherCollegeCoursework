/* 
 * File:   stack.cpp
 * Author: krumse01
 * 
 * Created on April 13, 2016, 7:44 PM
 */

#include <vector>
#include "stack.h"

Stack::Stack() {
}

void Stack::push(int x) {
    vec.push_back(x);
}

int Stack::pop() {
    int x = vec.back();
    vec.pop_back();
    return x;
}

int Stack::top() {
    return vec.back();
}

bool Stack::isEmpty() {
    return vec.size() == 0;
}