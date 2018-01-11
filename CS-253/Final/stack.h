/* 
 * File:   stack.h
 * Author: krumse01
 *
 * Created on May 4, 2016, 9:19 AM
 */

#ifndef STACK_H
#define	STACK_H

#include <vector>

template<class T>
class Stack {
public:
    Stack();
    void push(T);
    T pop();
    bool isEmpty();
    T top();
private:
    std::vector<T> vec;
};

template<class T>
Stack<T>::Stack() {}

template<class T>
void Stack<T>::push(T x) {
    vec.push_back(x);
}

template<class T>
T Stack<T>::pop() {
    T x = vec.back();
    vec.pop_back();
    return x;
}

template<class T>
bool Stack<T>::isEmpty() {
    return vec.size() == 0;
}

template<class T>
T Stack<T>::top() {
    return vec.back();
}

#endif	/* STACK_H */

