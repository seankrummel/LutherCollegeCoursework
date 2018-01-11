
public class Fraction /*extends Object*/ {

    private int top;
    private int bottom;
    private boolean displayDecimal = false;

    public Fraction(int n, int d) {
        int gcd = gcd(n, d);
        top = n / gcd;
        bottom = d / gcd;
    }

    public Fraction(int n) {
        this(n, 1);
    }

    @Override
    public String toString() {
        if (displayDecimal) {
            return ((double) top / bottom) + "";
        } else if (bottom == 1) {
            return top + "";
        } else {
            return top + "/" + bottom;
        }
    }

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return gcd(y, x % y);
    }

    public Fraction add(Fraction other) {
        int top1 = top * other.bottom;
        int top2 = other.top * bottom;
        int bot = bottom * other.bottom;
        return new Fraction(top1 + top2, bot);
    }

    public Fraction subtract(Fraction other) {
        int top1 = top * other.bottom;
        int top2 = other.top * bottom;
        int bot = bottom * other.bottom;
        return new Fraction(top1 - top2, bot);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(top * other.top, bottom * other.bottom);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(top * other.bottom, bottom * other.top);
    }

    public double decimalForm() {
        return (double) top / bottom;
    }

    public Fraction negate() {
        return new Fraction(top * -1, bottom);
    }

    public void toggleDisplay() {
        displayDecimal = !displayDecimal;
    }
}
