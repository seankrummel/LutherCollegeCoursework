/* 
 * File:   stack.h
 * Author: krumse01
 *
 * Created on April 13, 2016, 7:44 PM
 */

#ifndef STACK_H
#define	STACK_H

#include <vector>

class Stack {
public:
    Stack();
    void push(int);
    int pop();
    bool isEmpty();
    int top();
private:
    std::vector<int> vec;
};

#endif	/* STACK_H */

