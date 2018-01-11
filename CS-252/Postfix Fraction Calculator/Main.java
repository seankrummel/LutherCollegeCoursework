
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String line = in.nextLine();
        HashMap<String, Fraction> memory = new HashMap();

        while (!line.equals("")) {
            Stack<Fraction> stk = new Stack();
            boolean dblFound = false;
            boolean exFound = false;
            // System.out.println("Processing " + line);
            StringTokenizer lineIn = new StringTokenizer(line, " ()+-*/", true);
            while (lineIn.hasMoreTokens()) {
                String token = lineIn.nextToken();
                char aChar = token.charAt(0); // read one char
                // System.out.println(aChar);
                int top, bottom;
                double number;
                String tmp;
                Fraction f1, f2;
                switch (aChar) {
                    case '(': // gets the entire fraction
                        try {
                            // System.out.println("Found (");
                            top = new Integer(lineIn.nextToken());
                            lineIn.nextToken();
                            bottom = new Integer(lineIn.nextToken());
                            lineIn.nextToken();

                            // create fraction using top and bottom
                            Fraction f = new Fraction(top, bottom);
                            // System.out.println("Found " + f);
                            stk.push(f);
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case '+': // adds first two items on stack
                        try {
                            // System.out.println("Found +");
                            f2 = stk.pop();
                            f1 = stk.pop();
                            stk.push(f1.add(f2));
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case '-': // subtracts first two items on stack
                        try {
                            // System.out.println("Found -");
                            f2 = stk.pop();
                            f1 = stk.pop();
                            stk.push(f1.subtract(f2));
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case '*': // multiplys first two items on stack
                        try {
                            // System.out.println("Found *");
                            f2 = stk.pop();
                            f1 = stk.pop();
                            stk.push(f1.multiply(f2));
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case '/': // divides first two items on stack
                        try {
                            // System.out.println("Found /");
                            f2 = stk.pop();
                            f1 = stk.pop();
                            stk.push(f1.divide(f2));
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case 's': // process S
                    case 'S':
                        try {
                            // System.out.println("Found S");
                            tmp = lineIn.nextToken();
                            while (tmp.equals(" ")) {
                                tmp = lineIn.nextToken();
                            }
                            // System.out.println("saving " + tmp);
                            memory.put(tmp, stk.peek());
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case 'r': // process R
                    case 'R':
                        try {
                            // System.out.println("Found R");
                            tmp = lineIn.nextToken();
                            while (tmp.equals(" ")) {
                                tmp = lineIn.nextToken();
                            }
                            stk.push(memory.get(tmp));
                        } catch (Exception ex) {
                            exFound = true;
                        }
                        break;
                    case ' ': // skip whitespace
                        break;
                    default: // process doubles
                        number = new Double(token);
                        // System.out.println("Found " + number);
                        bottom = 1;
                        // get rid of decimal so that we can make a fraction
                        while (number - (int) number != 0) {
                            number *= 10;
                            bottom *= 10;
                        }
                        stk.push(new Fraction((int) number, bottom));
                        dblFound = true;

                }
            }
            try {
                Fraction x = stk.pop();
                if (!stk.isEmpty() || exFound) {
                    System.err.println("Malformed Exession");
                } else if (dblFound) {
                    System.out.println("It is: " + x.decimalForm());
                } else {
                    System.out.println("It is: " + x);
                }
            } catch (Exception ex) {
                System.err.println("Malformed Expression");
            }

            System.out.print("Enter an expression: ");
            line = in.nextLine();
        }

    }
}
