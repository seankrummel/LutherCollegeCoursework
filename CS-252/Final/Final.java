
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Final extends javax.swing.JFrame {

    private JTextArea textEnter = new JTextArea(10, 0);
    private final HashMap<Integer, JButton> buttonMap = new HashMap<>();
    private String editedText = "";
    private Stack<Fraction> stk = new Stack<>();
    private HashMap<String, Fraction> memory = new HashMap<>();

    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int val = e.getKeyCode();
            if (e.isShiftDown()) {
                val += 256;
            }
            // System.out.println(val);
            if (buttonMap.containsKey(val)) {
                buttonMap.get(val).doClick();
            }
        }
    }

    private void edit(String str) {
        textEnter.append(str);
        editedText += str;
        this.requestFocus();
    }

    private void refreshDisplay() {
        textEnter.setText("");
        for (int i = 0; i < 9 - stk.size(); i++) {
            textEnter.append("\n");
        }
        textEnter.append(stk.toString());
        editedText = "";
        this.requestFocus();
    }

    public Final() {
        initComponents();
        this.setSize(new Dimension(525, 400));
        this.setTitle("Calculator");
        this.setFocusable(true);
        textEnter.setFocusable(false);
        textEnter.setEditable(false);

        // design button layout
        this.setLayout(new BorderLayout());
        // JTextArea textEnter = new JTextArea(10, 0);
        this.add(new JScrollPane(textEnter), BorderLayout.NORTH);
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        this.add(panelCenter, BorderLayout.CENTER);
        JPanel panelLetters = new JPanel();
        panelLetters.setLayout(new GridLayout(2, 13));
        panelCenter.add(panelLetters, BorderLayout.NORTH);
        JButton buttonA = new JButton("A");
        panelLetters.add(buttonA);
        JButton buttonB = new JButton("B");
        panelLetters.add(buttonB);
        JButton buttonC = new JButton("C");
        panelLetters.add(buttonC);
        JButton buttonD = new JButton("D");
        panelLetters.add(buttonD);
        JButton buttonE = new JButton("E");
        panelLetters.add(buttonE);
        JButton buttonF = new JButton("F");
        panelLetters.add(buttonF);
        JButton buttonG = new JButton("G");
        panelLetters.add(buttonG);
        JButton buttonH = new JButton("H");
        panelLetters.add(buttonH);
        JButton buttonI = new JButton("I");
        panelLetters.add(buttonI);
        JButton buttonJ = new JButton("J");
        panelLetters.add(buttonJ);
        JButton buttonK = new JButton("K");
        panelLetters.add(buttonK);
        JButton buttonL = new JButton("L");
        panelLetters.add(buttonL);
        JButton buttonM = new JButton("M");
        panelLetters.add(buttonM);
        JButton buttonN = new JButton("N");
        panelLetters.add(buttonN);
        JButton buttonO = new JButton("O");
        panelLetters.add(buttonO);
        JButton buttonP = new JButton("P");
        panelLetters.add(buttonP);
        JButton buttonQ = new JButton("Q");
        panelLetters.add(buttonQ);
        JButton buttonR = new JButton("R");
        panelLetters.add(buttonR);
        JButton buttonS = new JButton("S");
        panelLetters.add(buttonS);
        JButton buttonT = new JButton("T");
        panelLetters.add(buttonT);
        JButton buttonU = new JButton("U");
        panelLetters.add(buttonU);
        JButton buttonV = new JButton("V");
        panelLetters.add(buttonV);
        JButton buttonW = new JButton("W");
        panelLetters.add(buttonW);
        JButton buttonX = new JButton("X");
        panelLetters.add(buttonX);
        JButton buttonY = new JButton("Y");
        panelLetters.add(buttonY);
        JButton buttonZ = new JButton("Z");
        panelLetters.add(buttonZ);
        JPanel panelDecFrac = new JPanel();
        panelDecFrac.setLayout(new BorderLayout());
        panelCenter.add(panelDecFrac, BorderLayout.WEST);
        JButton buttonDecFrac = new JButton("DEC/FRAC");
        panelDecFrac.add(buttonDecFrac, BorderLayout.NORTH);
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(3, 2));
        panelDecFrac.add(panelButtons, BorderLayout.CENTER);
//        JButton buttonDEC = new JButton("DEC");
//        panelButtons.add(buttonDEC);
//        JButton buttonFRAC = new JButton("FRAC");
//        panelButtons.add(buttonFRAC);
        JButton buttonLParen = new JButton("(");
        panelButtons.add(buttonLParen);
        JButton buttonRParen = new JButton(")");
        panelButtons.add(buttonRParen);
        JButton buttonSWAP = new JButton("SWAP");
        panelButtons.add(buttonSWAP);
        JButton buttonBACK = new JButton("BACK");
        panelButtons.add(buttonBACK);
        JButton buttonSTORE = new JButton("STORE");
        panelButtons.add(buttonSTORE);
        JButton buttonRECALL = new JButton("RECALL");
        panelButtons.add(buttonRECALL);
        JPanel panelEnter = new JPanel();
        panelEnter.setLayout(new BorderLayout());
        panelCenter.add(panelEnter, BorderLayout.CENTER);
        JButton buttonSPACE = new JButton("SPACE");
        panelEnter.add(buttonSPACE, BorderLayout.NORTH);
        JButton buttonENTER = new JButton("ENTER");
        panelEnter.add(buttonENTER, BorderLayout.CENTER);
        JPanel panelNums = new JPanel();
        panelNums.setLayout(new GridLayout(4, 4));
        panelCenter.add(panelNums, BorderLayout.EAST);
        JButton button7 = new JButton("7");
        panelNums.add(button7);
        JButton button8 = new JButton("8");
        panelNums.add(button8);
        JButton button9 = new JButton("9");
        panelNums.add(button9);
        JButton buttonDivide = new JButton("/");
        panelNums.add(buttonDivide);
        JButton button4 = new JButton("4");
        panelNums.add(button4);
        JButton button5 = new JButton("5");
        panelNums.add(button5);
        JButton button6 = new JButton("6");
        panelNums.add(button6);
        JButton buttonTimes = new JButton("*");
        panelNums.add(buttonTimes);
        JButton button1 = new JButton("1");
        panelNums.add(button1);
        JButton button2 = new JButton("2");
        panelNums.add(button2);
        JButton button3 = new JButton("3");
        panelNums.add(button3);
        JButton buttonMinus = new JButton("-");
        panelNums.add(buttonMinus);
        JButton button0 = new JButton("0");
        panelNums.add(button0);
        JButton buttonDecimal = new JButton(".");
        panelNums.add(buttonDecimal);
        JButton buttonNeg = new JButton("+/-");
        panelNums.add(buttonNeg);
        JButton buttonPlus = new JButton("+");
        panelNums.add(buttonPlus);

        refreshDisplay();

        // add action listeners to all buttons
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("A");
            }
        });
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("B");
            }
        });
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("C");
            }
        });
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("D");
            }
        });
        buttonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("E");
            }
        });
        buttonF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("F");
            }
        });
        buttonG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("G");
            }
        });
        buttonH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("H");
            }
        });
        buttonI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("I");
            }
        });
        buttonJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("J");
            }
        });
        buttonK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("K");
            }
        });
        buttonL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("L");
            }
        });
        buttonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("M");
            }
        });
        buttonN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("N");
            }
        });
        buttonO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("O");
            }
        });
        buttonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("P");
            }
        });
        buttonQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("Q");
            }
        });
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("R");
            }
        });
        buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("S");
            }
        });
        buttonT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("T");
            }
        });
        buttonU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("U");
            }
        });
        buttonV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("V");
            }
        });
        buttonW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("W");
            }
        });
        buttonX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("X");
            }
        });
        buttonY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("Y");
            }
        });
        buttonZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("Z");
            }
        });
        buttonDecFrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stk.peek().toggleDisplay();
                String temp = editedText;
                refreshDisplay();
                edit(temp);
            }
        });
        buttonLParen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("(");
            }
        });
        buttonRParen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit(")");
            }
        });
        buttonSWAP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fraction a = stk.pop();
                Fraction b = stk.pop();
                stk.push(a);
                stk.push(b);
                refreshDisplay();
            }
        });
        buttonBACK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editedText.isEmpty()) {
                    if (!stk.isEmpty()) {
                        stk.pop();
                    }
                    refreshDisplay();
                } else {
                    editedText = editedText.substring(0, editedText.length() - 1);
                    String x = textEnter.getText().substring(0,
                            textEnter.getText().length() - 1);
                    textEnter.replaceRange(x, 0, textEnter.getText().length());
                }
            }
        });
        buttonSTORE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("s");
                // lowercase to differentiate store key from the letter key S
            }
        });
        buttonRECALL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("r");
                // lowercase to differentiate recall key from the letter key R
            }
        });
        buttonSPACE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit(" ");
            }
        });
        buttonENTER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringTokenizer line = new StringTokenizer(editedText,
                        " ()+-*/~sr", true);
                int stkSize = stk.size();
                while (line.hasMoreTokens()) {
                    try {
                        int top, bottom;
                        double number;
                        Fraction f1, f2;
                        String tmp;
                        stkSize = stk.size();
                        String token = line.nextToken();
                        char aChar = token.charAt(0);
                        switch (aChar) {
                            case '(':
                                // read number
                                top = new Integer(line.nextToken());
                                line.nextToken(); // skip the /
                                // read number
                                bottom = new Integer(line.nextToken());
                                line.nextToken(); // skip the )

                                Fraction f = new Fraction(top, bottom);
                                stk.push(f);
                                break;
                            case '+':
                                f2 = stk.pop();
                                f1 = stk.pop();
                                stk.push(f1.add(f2));
                                break;
                            case '-':
                                f2 = stk.pop();
                                f1 = stk.pop();
                                stk.push(f1.subtract(f2));
                                break;
                            case '*':
                                f2 = stk.pop();
                                f1 = stk.pop();
                                stk.push(f1.multiply(f2));
                                break;
                            case '/':
                                f2 = stk.pop();
                                f1 = stk.pop();
                                stk.push(f1.divide(f2));
                                break;
                            case '~':
                                stk.push(stk.pop().negate());
                                break;
                            case 's':
                                // skip whitespace
                                tmp = line.nextToken();
                                while (tmp.equals(" ")) {
                                    tmp = line.nextToken();
                                }

                                memory.put(tmp, stk.peek());
                                break;
                            case 'r':
                                // skip whitespace
                                tmp = line.nextToken();
                                while (tmp.equals(" ")) {
                                    tmp = line.nextToken();
                                }

                                stk.push(memory.get(tmp));
                                break;
                            case ' ':
                                break; // skip whitespace
                            default:
                                number = new Double(token);
                                bottom = 1;
                                while (number - (int) number != 0) {
                                    number *= 10;
                                    bottom *= 10;
                                }
                                stk.push(new Fraction((int) number, bottom));
                                break;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                                "Malformed Expression", "Alert",
                                JOptionPane.WARNING_MESSAGE);
                        while (stk.size() > stkSize) {
                            stk.pop();
                        }
                    }
                }

                if (stk.size() > stk.size() + 1) {
                    JOptionPane.showMessageDialog(null, "Malformed Expression",
                            "Alert", JOptionPane.WARNING_MESSAGE);
                    while (stk.size() > stkSize) {
                        stk.pop();
                    }
                }
                refreshDisplay();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("9");
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("/");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("6");
            }
        });
        buttonTimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("*");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("3");
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("-");
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("0");
            }
        });
        buttonDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit(".");
            }
        });
        buttonNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("~");
            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit("+");
            }
        });

        // setup buttonMap
        buttonMap.put(65, buttonA);
        buttonMap.put(66, buttonB);
        buttonMap.put(67, buttonC);
        buttonMap.put(68, buttonD);
        buttonMap.put(69, buttonE);
        buttonMap.put(70, buttonF);
        buttonMap.put(71, buttonG);
        buttonMap.put(72, buttonH);
        buttonMap.put(73, buttonI);
        buttonMap.put(74, buttonJ);
        buttonMap.put(75, buttonK);
        buttonMap.put(76, buttonL);
        buttonMap.put(77, buttonM);
        buttonMap.put(78, buttonN);
        buttonMap.put(79, buttonO);
        buttonMap.put(80, buttonP);
        buttonMap.put(81, buttonQ);
        buttonMap.put(82, buttonR);
        buttonMap.put(83, buttonS);
        buttonMap.put(84, buttonT);
        buttonMap.put(85, buttonU);
        buttonMap.put(86, buttonV);
        buttonMap.put(87, buttonW);
        buttonMap.put(88, buttonX);
        buttonMap.put(89, buttonY);
        buttonMap.put(90, buttonZ);
        buttonMap.put(313, buttonLParen); // shift + 9
        buttonMap.put(304, buttonRParen); // shift + 0
        buttonMap.put(8, buttonBACK);
        buttonMap.put(12, buttonBACK); // numpad clear
        buttonMap.put(32, buttonSPACE);
        buttonMap.put(10, buttonENTER);
        buttonMap.put(61, buttonENTER); // = will also be enter
        buttonMap.put(55, button7);
        buttonMap.put(103, button7); // numpad 7
        buttonMap.put(56, button8);
        buttonMap.put(104, button8); // numpad 8
        buttonMap.put(57, button9);
        buttonMap.put(105, button9); // numpad 9
        buttonMap.put(47, buttonDivide);
        buttonMap.put(111, buttonDivide); // numpad /
        buttonMap.put(52, button4);
        buttonMap.put(100, button4); // numpad 4
        buttonMap.put(53, button5);
        buttonMap.put(101, button5); // numpad 5
        buttonMap.put(54, button6);
        buttonMap.put(102, button6); // numpad 6
        buttonMap.put(312, buttonTimes); // shift + 8
        buttonMap.put(106, buttonTimes); // numpad *
        buttonMap.put(49, button1);
        buttonMap.put(97, button1); // numpad 1
        buttonMap.put(50, button2);
        buttonMap.put(98, button2); // numpad 2
        buttonMap.put(51, button3);
        buttonMap.put(99, button3); // numpad 3
        buttonMap.put(45, buttonMinus);
        buttonMap.put(109, buttonMinus); // numpad -
        buttonMap.put(48, button0);
        buttonMap.put(96, button0); // numpad 0
        buttonMap.put(46, buttonDecimal);
        buttonMap.put(55, buttonDecimal); // numpad .
        buttonMap.put(448, buttonNeg); // shift + `
        buttonMap.put(317, buttonPlus); // shift + =
        buttonMap.put(107, buttonPlus); // numpad +
        addKeyListener(new MyKeyListener());
        requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Final().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
