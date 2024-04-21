package src.View;

import javax.swing.*;
import java.awt.event.*;

public class AddBankAccount extends JDialog {
    private JPanel contentPane;
    private JTextField tfAccountName;
    private JTextField tfAccountNum;
    private JTextField tfRoutingNum;
    private JTextField tfInitialBal;
    private JButton buttonConfirm;
    private JButton buttonCancel;

    public AddBankAccount() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonConfirm);

        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConfirm();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onConfirm() {
        // Retrieve user input from text fields
        String accName = tfAccountName.getText();
        String accNum = tfAccountNum.getText();
        String routingNum = tfRoutingNum.getText();
        String bal = tfInitialBal.getText();


        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
