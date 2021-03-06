
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class FractionGUIFrame extends javax.swing.JFrame {

    Stack<Fraction> stk = new Stack();
    Fraction memory;

    /**
     * Creates new form FractionGUIFrame
     */
    public FractionGUIFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInput = new javax.swing.JPanel();
        panelSpaceEnter = new javax.swing.JPanel();
        keyEnter = new javax.swing.JButton();
        keySpace = new javax.swing.JButton();
        panelInput2 = new javax.swing.JPanel();
        keyBackspace = new javax.swing.JButton();
        panelInput3 = new javax.swing.JPanel();
        keyLeftParen = new javax.swing.JButton();
        keyRightParen = new javax.swing.JButton();
        keyS = new javax.swing.JButton();
        keyR = new javax.swing.JButton();
        panelNumbers = new javax.swing.JPanel();
        key7 = new javax.swing.JButton();
        key8 = new javax.swing.JButton();
        key9 = new javax.swing.JButton();
        keyPlus = new javax.swing.JButton();
        key4 = new javax.swing.JButton();
        key5 = new javax.swing.JButton();
        key6 = new javax.swing.JButton();
        keyMinus = new javax.swing.JButton();
        key1 = new javax.swing.JButton();
        key2 = new javax.swing.JButton();
        key3 = new javax.swing.JButton();
        keyTimes = new javax.swing.JButton();
        key0 = new javax.swing.JButton();
        keyDecimal = new javax.swing.JButton();
        keyNeg = new javax.swing.JButton();
        keyDivide = new javax.swing.JButton();
        panelDisplay = new javax.swing.JPanel();
        jTextFieldEntry = new javax.swing.JTextField();
        jScrollPaneStack = new javax.swing.JScrollPane();
        jTextAreaStack = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelInput.setLayout(new java.awt.BorderLayout());

        panelSpaceEnter.setLayout(new java.awt.BorderLayout());

        keyEnter.setText("Enter");
        keyEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyEnterActionPerformed(evt);
            }
        });
        panelSpaceEnter.add(keyEnter, java.awt.BorderLayout.CENTER);

        keySpace.setText("Space");
        keySpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keySpaceActionPerformed(evt);
            }
        });
        panelSpaceEnter.add(keySpace, java.awt.BorderLayout.PAGE_START);

        panelInput.add(panelSpaceEnter, java.awt.BorderLayout.CENTER);

        panelInput2.setLayout(new java.awt.BorderLayout());

        keyBackspace.setText("Backspace/Clear");
        keyBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyBackspaceActionPerformed(evt);
            }
        });
        panelInput2.add(keyBackspace, java.awt.BorderLayout.CENTER);

        panelInput3.setLayout(new java.awt.GridLayout(2, 2));

        keyLeftParen.setText("(");
        keyLeftParen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyLeftParenActionPerformed(evt);
            }
        });
        panelInput3.add(keyLeftParen);

        keyRightParen.setText(")");
        keyRightParen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRightParenActionPerformed(evt);
            }
        });
        panelInput3.add(keyRightParen);

        keyS.setText("Store");
        keyS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keySActionPerformed(evt);
            }
        });
        panelInput3.add(keyS);

        keyR.setText("Recall");
        keyR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyRActionPerformed(evt);
            }
        });
        panelInput3.add(keyR);

        panelInput2.add(panelInput3, java.awt.BorderLayout.PAGE_END);

        panelInput.add(panelInput2, java.awt.BorderLayout.LINE_START);

        panelNumbers.setLayout(new java.awt.GridLayout(4, 4));

        key7.setText("7");
        key7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key7ActionPerformed(evt);
            }
        });
        panelNumbers.add(key7);

        key8.setText("8");
        key8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key8ActionPerformed(evt);
            }
        });
        panelNumbers.add(key8);

        key9.setText("9");
        key9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key9ActionPerformed(evt);
            }
        });
        panelNumbers.add(key9);

        keyPlus.setText("+");
        keyPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPlusActionPerformed(evt);
            }
        });
        panelNumbers.add(keyPlus);

        key4.setText("4");
        key4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key4ActionPerformed(evt);
            }
        });
        panelNumbers.add(key4);

        key5.setText("5");
        key5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key5ActionPerformed(evt);
            }
        });
        panelNumbers.add(key5);

        key6.setText("6");
        key6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key6ActionPerformed(evt);
            }
        });
        panelNumbers.add(key6);

        keyMinus.setText("-");
        keyMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyMinusActionPerformed(evt);
            }
        });
        panelNumbers.add(keyMinus);

        key1.setText("1");
        key1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key1ActionPerformed(evt);
            }
        });
        panelNumbers.add(key1);

        key2.setText("2");
        key2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key2ActionPerformed(evt);
            }
        });
        panelNumbers.add(key2);

        key3.setText("3");
        key3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key3ActionPerformed(evt);
            }
        });
        panelNumbers.add(key3);

        keyTimes.setText("*");
        keyTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyTimesActionPerformed(evt);
            }
        });
        panelNumbers.add(keyTimes);

        key0.setText("0");
        key0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key0ActionPerformed(evt);
            }
        });
        panelNumbers.add(key0);

        keyDecimal.setText(".");
        keyDecimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyDecimalActionPerformed(evt);
            }
        });
        panelNumbers.add(keyDecimal);

        keyNeg.setText("+/-");
        keyNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyNegActionPerformed(evt);
            }
        });
        panelNumbers.add(keyNeg);

        keyDivide.setText("/");
        keyDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyDivideActionPerformed(evt);
            }
        });
        panelNumbers.add(keyDivide);

        panelInput.add(panelNumbers, java.awt.BorderLayout.LINE_END);

        getContentPane().add(panelInput, java.awt.BorderLayout.PAGE_END);

        panelDisplay.setLayout(new java.awt.BorderLayout());
        panelDisplay.add(jTextFieldEntry, java.awt.BorderLayout.PAGE_END);

        jTextAreaStack.setColumns(20);
        jTextAreaStack.setRows(5);
        jScrollPaneStack.setViewportView(jTextAreaStack);

        panelDisplay.add(jScrollPaneStack, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelDisplay, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keyEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyEnterActionPerformed
        // This is where most of FractionRPN's Main will go
        StringTokenizer line = new StringTokenizer(jTextFieldEntry.getText(),
                " ()+-*/~SR", true);
        int stkSize = stk.size();
        while (line.hasMoreTokens()) {
            try {
                int top, bottom;
                double number;
                Fraction f1, f2;
                stkSize = stk.size();
                String token = line.nextToken();
                char aChar = token.charAt(0);
                switch (aChar) {
                    case '(':
                        top = new Integer(line.nextToken()); // read number
                        line.nextToken(); // skip /
                        bottom = new Integer(line.nextToken()); // read number
                        line.nextToken(); // skip )

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
                    case 'S':
                        memory = stk.peek();
                        break;
                    case 'R':
                        stk.push(memory);
                        break;
                    case ' ':
                        break;
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Malformed Expression",
                        "Alert", JOptionPane.WARNING_MESSAGE);
                while (stk.size() > stkSize) {
                    stk.pop();
                }
            }
        }

        if (stk.size() > stkSize + 1) {
            JOptionPane.showMessageDialog(null, "Malformed Expression",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            while (stk.size() > stkSize) {
                stk.pop();
            }
        }

        jTextAreaStack.setText("The Stack:\n" + stk);

        jTextFieldEntry.setText("");
        // reset the Entry line 

    }//GEN-LAST:event_keyEnterActionPerformed

    private void key0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key0ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "0");
    }//GEN-LAST:event_key0ActionPerformed

    private void key1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key1ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "1");
    }//GEN-LAST:event_key1ActionPerformed

    private void key2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key2ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "2");
    }//GEN-LAST:event_key2ActionPerformed

    private void key3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key3ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "3");
    }//GEN-LAST:event_key3ActionPerformed

    private void key4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key4ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "4");
    }//GEN-LAST:event_key4ActionPerformed

    private void key5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key5ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "5");
    }//GEN-LAST:event_key5ActionPerformed

    private void key6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key6ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "6");
    }//GEN-LAST:event_key6ActionPerformed

    private void key7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key7ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "7");
    }//GEN-LAST:event_key7ActionPerformed

    private void key8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key8ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "8");
    }//GEN-LAST:event_key8ActionPerformed

    private void key9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key9ActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "9");
    }//GEN-LAST:event_key9ActionPerformed

    private void keyPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPlusActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "+");
    }//GEN-LAST:event_keyPlusActionPerformed

    private void keyMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyMinusActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "-");
    }//GEN-LAST:event_keyMinusActionPerformed

    private void keyTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyTimesActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "*");
    }//GEN-LAST:event_keyTimesActionPerformed

    private void keyDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyDivideActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "/");
    }//GEN-LAST:event_keyDivideActionPerformed

    private void keyNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyNegActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "~");
    }//GEN-LAST:event_keyNegActionPerformed

    private void keyLeftParenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyLeftParenActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "(");
    }//GEN-LAST:event_keyLeftParenActionPerformed

    private void keyRightParenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRightParenActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + ")");
    }//GEN-LAST:event_keyRightParenActionPerformed

    private void keyDecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyDecimalActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + ".");
    }//GEN-LAST:event_keyDecimalActionPerformed

    private void keySActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keySActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "S");
    }//GEN-LAST:event_keySActionPerformed

    private void keyRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyRActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + "R");
    }//GEN-LAST:event_keyRActionPerformed

    private void keyBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyBackspaceActionPerformed
        if (jTextFieldEntry.getText().isEmpty()) {
            // if the entry field is empty, clear the stack
            while (!stk.isEmpty()) {
                stk.pop();
            }
            jTextAreaStack.setText("The Stack:\n" + stk); // display the stack
        } else {
            String text = jTextFieldEntry.getText();
            text = text.substring(0, text.length() - 1);
            jTextFieldEntry.setText(text);
        }
    }//GEN-LAST:event_keyBackspaceActionPerformed

    private void keySpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keySpaceActionPerformed
        jTextFieldEntry.setText(jTextFieldEntry.getText() + " ");
    }//GEN-LAST:event_keySpaceActionPerformed

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
            java.util.logging.Logger.getLogger(FractionGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FractionGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FractionGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FractionGUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FractionGUIFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneStack;
    private javax.swing.JTextArea jTextAreaStack;
    private javax.swing.JTextField jTextFieldEntry;
    private javax.swing.JButton key0;
    private javax.swing.JButton key1;
    private javax.swing.JButton key2;
    private javax.swing.JButton key3;
    private javax.swing.JButton key4;
    private javax.swing.JButton key5;
    private javax.swing.JButton key6;
    private javax.swing.JButton key7;
    private javax.swing.JButton key8;
    private javax.swing.JButton key9;
    private javax.swing.JButton keyBackspace;
    private javax.swing.JButton keyDecimal;
    private javax.swing.JButton keyDivide;
    private javax.swing.JButton keyEnter;
    private javax.swing.JButton keyLeftParen;
    private javax.swing.JButton keyMinus;
    private javax.swing.JButton keyNeg;
    private javax.swing.JButton keyPlus;
    private javax.swing.JButton keyR;
    private javax.swing.JButton keyRightParen;
    private javax.swing.JButton keyS;
    private javax.swing.JButton keySpace;
    private javax.swing.JButton keyTimes;
    private javax.swing.JPanel panelDisplay;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelInput2;
    private javax.swing.JPanel panelInput3;
    private javax.swing.JPanel panelNumbers;
    private javax.swing.JPanel panelSpaceEnter;
    // End of variables declaration//GEN-END:variables
}
