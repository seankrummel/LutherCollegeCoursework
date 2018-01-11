/* 
 * File:   fraction.h
 * Author: krumse01
 *
 * Created on May 4, 2016, 9:19 AM
 */

#ifndef FRACTION_H
#define	FRACTION_H

#include <iostream>
using namespace std;

class Fraction {
public:
    Fraction();
    Fraction(int);
    Fraction(int,int);
    int numerator() const;
    int denominator() const;
    double asDouble() const;
    Fraction add(const Fraction&) const;
    Fraction subtract(const Fraction&) const;
    Fraction divide(const Fraction&) const;
    Fraction multiply(const Fraction&) const;
private:
    int top;
    int bottom;
};

Fraction operator+(const Fraction& a, const Fraction& b);
Fraction operator-(const Fraction& a, const Fraction& b);
Fraction operator*(const Fraction& a, const Fraction& b);
Fraction operator/(const Fraction& a, const Fraction& b);
Fraction operator<<(ostream&, const Fraction& f);

#endif	/* FRACTION_H */

