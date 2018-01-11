/* 
 * File:   fraction.cpp
 * Author: krumse01
 * 
 * Created on May 4, 2016, 9:19 AM
 */

#include "fraction.h"

// greatest common divisor code provided
int gcd(int x, int y) {
    if (y==0)
        return x;
    return gcd(y, x%y);
}

Fraction::Fraction() : Fraction(0) {}
// if default constructor is called, just make fraction with numerator=0

Fraction::Fraction(int n) {
    top = n;
    bottom = 1;
    // when only numerator is provided, denominator will always be 1
}

Fraction::Fraction(int n, int d) {
    int div = gcd(n,d);
    top = n/div;
    bottom = d/div;
    // find greatest common divisor, divide numerator and denominator by it
    // to simplify fraction
}

int Fraction::numerator() const {
    return top;
}

int Fraction::denominator() const {
    return bottom;
}

double Fraction::asDouble() const {
    return (double)top/(double)bottom;
}

Fraction Fraction::add(const Fraction& x) const {
    int num = top * x.denominator() + x.numerator() * bottom;
    int den = bottom * x.denominator();
    return Fraction(num,den);
}

Fraction Fraction::subtract(const Fraction& x) const {
    int num = top * x.denominator() - x.numerator() * bottom;
    int den = bottom * x.denominator();
    return Fraction(num,den);
}

Fraction Fraction::divide(const Fraction& x) const {
    int num = top * x.denominator();
    int den = bottom * x.numerator();
    return Fraction(num,den);
}

Fraction Fraction::multiply(const Fraction& x) const {
    int num = top * x.numerator();
    int den = bottom * x.denominator();
    return Fraction(num,den);
}

Fraction operator+(const Fraction& a, const Fraction& b) {
    return a.add(b);
}

Fraction operator-(const Fraction& a, const Fraction& b) {
    return a.subtract(b);
}

Fraction operator*(const Fraction& a, const Fraction& b) {
    return a.multiply(b);
}

Fraction operator/(const Fraction& a, const Fraction& b) {
    return a.divide(b);
}