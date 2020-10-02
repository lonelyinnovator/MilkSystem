/*
 * Created by JFormDesigner on Thu Oct 01 14:23:14 CST 2020
 */

package com.milkSystem.java;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Brainrain
 */
public class LogUpFrame extends JFrame {
    private UserList userList;
    private User user;
    private ProductCatalog productCatalog;
    public LogUpFrame(UserList initialUserList, ProductCatalog initialProductCatalog) {
        initComponents();
        userList = initialUserList;
        productCatalog = initialProductCatalog;
    }

//-------------------------------------------------------------------------------------------
    private void button1MouseClicked(MouseEvent e) {
    }

    private void button2MouseClicked(MouseEvent e) {
    }
//-------------------------------------------------------------------------------------------

    private void button2ActionPerformed(ActionEvent e) {
        String msg = "NULL";
        if(textField1.getText().equals("")){
            msg += " UserName";
        }
        if(textField2.getText().equals("")){
            msg += " Email";
        }
        if(String.valueOf(passwordField1.getPassword()).equals("")){
            msg += " Password";
        }
        if(!msg.equals("NULL")){
            JOptionPane.showMessageDialog(this, msg,"warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        user = new User(textField1.getText(), String.valueOf(passwordField1.getPassword()), textField2.getText(),null);
        userList.addUser(user);
        dispose();
        MilkSystem milkSystem = new MilkSystem(userList, user, productCatalog);
        milkSystem.setVisible(true);
        milkSystem.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void button1ActionPerformed(ActionEvent e) {
        dispose();
        LogFrame logFrame = new LogFrame(userList, productCatalog);
        logFrame.setVisible(true);
        logFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[83,fill]" +
            "[161,fill]" +
            "[197,fill]" +
            "[99,fill]" +
            "[61,fill]",
            // rows
            "[80]" +
            "[73]" +
            "[74]" +
            "[75]" +
            "[84]"));

        //---- label1 ----
        label1.setText("UsrName:");
        label1.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label1, "cell 1 1,align center center,grow 0 0");

        //---- textField1 ----
        textField1.setFont(new Font("Consolas", Font.PLAIN, 20));
        contentPane.add(textField1, "cell 2 1 2 1,growy");

        //---- label2 ----
        label2.setText("Email:");
        label2.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label2, "cell 1 2,align center center,grow 0 0");

        //---- textField2 ----
        textField2.setFont(new Font("Consolas", Font.PLAIN, 20));
        contentPane.add(textField2, "cell 2 2 2 1,growy");

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label3, "cell 1 3,align center center,grow 0 0");

        //---- passwordField1 ----
        passwordField1.setFont(new Font("Consolas", Font.PLAIN, 20));
        contentPane.add(passwordField1, "cell 2 3 2 1,growy");

        //---- button1 ----
        button1.setText("return");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 1 4,alignx center,growx 0");

        //---- button2 ----
        button2.setText("log up");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 3 4,align center center,grow 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
