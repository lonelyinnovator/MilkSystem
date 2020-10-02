/*
 * Created by JFormDesigner on Thu Oct 01 14:38:16 CST 2020
 */

package com.milkSystem.java;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import net.miginfocom.swing.*;

/**
 * @author Brainrain
 */
public class MilkSystem extends JFrame {
    private UserList userList;
    private User user;
    private ProductCatalog productCatalog;
    private Order order;
    private SaleItem saleItem;
    private ProductSaleList productSaleList;
    private StoreSale storeSale;
    private DefaultListModel model1;
    private DefaultListModel model2;
    private DefaultListModel model3;
    public MilkSystem(UserList initialUserList, User initialUser, ProductCatalog initialProductCatalog) {
        initComponents();
        userList = initialUserList;
        user = initialUser;
        productCatalog = initialProductCatalog;
        textField1.setBorder(new EmptyBorder(0,0,0,0));
        textField2.setBorder(new EmptyBorder(0,0,0,0));
        textField2.setText(user.getUsrName());
        model1 = new DefaultListModel();
        for(Product product : productCatalog){
            model1.addElement(product.getCode() + " " + product.getDescription() + " $" + product.getPrice());
        }
        list1.setModel(model1);
        model2 = new DefaultListModel();
        model3 = new DefaultListModel();
        storeSale = new StoreSale();
    }

    public MilkSystem(){
    }

    private void list1ValueChanged(ListSelectionEvent e) {

        int index = list1.getSelectedIndex();
        if(productCatalog.getProduct(index) instanceof Jelly ){
            textArea1.setText("Code: " + productCatalog.getProduct(index).getCode() + '\n'
                    + "Description: " + productCatalog.getProduct(index).getDescription() + '\n'
                    + "Price: $" + productCatalog.getProduct(index).getPrice() + '\n'
                    + "ProductionDate: " + productCatalog.getProduct(index).getProductionDate() + '\n'
                    + "ShelfLife: " + productCatalog.getProduct(index).getShelfLife() + '\n'
                    + "Flavor: " + ((Jelly) productCatalog.getProduct(index)).getFlavor());
        }
        else if(productCatalog.getProduct(index) instanceof Yogurt){
            textArea1.setText("Code: " + productCatalog.getProduct(index).getCode() + '\n'
                    + "Description: " + productCatalog.getProduct(index).getDescription() + '\n'
                    + "Price: $" + productCatalog.getProduct(index).getPrice() + '\n'
                    + "ProductionDate: " + productCatalog.getProduct(index).getProductionDate() + '\n'
                    + "ShelfLife: " + productCatalog.getProduct(index).getShelfLife() + '\n'
                    + "Type: " + ((Yogurt) productCatalog.getProduct(index)).getType() + '\n'
                    + "DiluteConcentration" + ((Yogurt) productCatalog.getProduct(index)).getDiluteConcentration());
        }
        else if(productCatalog.getProduct(index) instanceof MilkDrink){
            textArea1.setText("Code: " + productCatalog.getProduct(index).getCode() + '\n'
                    + "Description: " + productCatalog.getProduct(index).getDescription() + '\n'
                    + "Price: $" + productCatalog.getProduct(index).getPrice() + '\n'
                    + "ProductionDate: " + productCatalog.getProduct(index).getProductionDate() + '\n'
                    + "ShelfLife: " + productCatalog.getProduct(index).getShelfLife() + '\n'
                    + "Flavor: " + ((MilkDrink) productCatalog.getProduct(index)).getFlavor() + '\n'
                    + "Sugar: " + ((MilkDrink) productCatalog.getProduct(index)).getSugar());
        }
        else if(productCatalog.getProduct(index) instanceof PureMilk){
            textArea1.setText("Code: " + productCatalog.getProduct(index).getCode() + '\n'
                    + "Description: " + productCatalog.getProduct(index).getDescription() + '\n'
                    + "Price: $" + productCatalog.getProduct(index).getPrice() + '\n'
                    + "ProductionDate: " + productCatalog.getProduct(index).getProductionDate() + '\n'
                    + "ShelfLife: " + productCatalog.getProduct(index).getShelfLife() + '\n'
                    + "CountryOfOrigin: " + ((PureMilk) productCatalog.getProduct(index)).getCountryOfOrigin() + '\n'
                    + "Butterfat: " + ((PureMilk) productCatalog.getProduct(index)).getButterfat() + '\n'
                    + "Protein: " + ((PureMilk) productCatalog.getProduct(index)).getProtein());
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        int i;
        int index = list1.getSelectedIndex();
        if(index == -1){
            return;
        }
        saleItem = new SaleItem(productCatalog.getProduct(index), 1);
        if(user.getOrder() == null){
            productSaleList = new ProductSaleList();
            productSaleList.addSaleItem(saleItem);
            order = new Order(productSaleList, 1);
            user.setOrder(order);
            model2.addElement(saleItem.getProduct().getCode() + " " + saleItem.getProduct().getDescription() + " $"
                    + saleItem.getProduct().getPrice() + " " + saleItem.getQuantity());
            list2.setModel(model2);
            textField1.setBorder(new EmptyBorder(0,0,0,0));
            textField1.setText("Total: $" + user.getOrder().getPorProductSaleList().getTotalCost());
            return;
        }
        for(i = 0; i < user.getOrder().getPorProductSaleList().getNumberOfItems(); i++){
            if(saleItem.getProduct().getCode().equals(user.getOrder().getPorProductSaleList().getSaleItem(i).getProduct().getCode())){
                user.getOrder().getPorProductSaleList().getSaleItem(i).setQuantity(user.getOrder().getPorProductSaleList().getSaleItem(i).getQuantity() + 1);
                model2.setElementAt(user.getOrder().getPorProductSaleList().getSaleItem(i).getProduct().getCode() + " "
                                    + user.getOrder().getPorProductSaleList().getSaleItem(i).getProduct().getDescription() + " $"
                                    + user.getOrder().getPorProductSaleList().getSaleItem(i).getProduct().getPrice() + " "
                                    + user.getOrder().getPorProductSaleList().getSaleItem(i).getQuantity(), i);
                list2.setModel(model2);
                textField1.setBorder(new EmptyBorder(0,0,0,0));
                textField1.setText("Total: $" + user.getOrder().getPorProductSaleList().getTotalCost());
                return;
            }
        }
        user.getOrder().getPorProductSaleList().addSaleItem(saleItem);
        model2.addElement(saleItem.getProduct().getCode() + " " + saleItem.getProduct().getDescription() + " $" +
                saleItem.getProduct().getPrice() + " " + saleItem.getQuantity());
        list2.setModel(model2);
        textField1.setBorder(new EmptyBorder(0,0,0,0));
        textField1.setText("Total: $" + user.getOrder().getPorProductSaleList().getTotalCost());
        return;
    }

    private void button2ActionPerformed(ActionEvent e) {
        int index = list2.getSelectedIndex();
        if(index == -1 || user.getOrder() == null || user.getOrder().getPorProductSaleList().getNumberOfItems() == 0){
            return;
        }
        user.getOrder().getPorProductSaleList().getSaleItem(index).setQuantity(user.getOrder().getPorProductSaleList().getSaleItem(index).getQuantity() - 1);
       if(user.getOrder().getPorProductSaleList().getSaleItem(index).getQuantity() == 0){
           user.getOrder().getPorProductSaleList().removeSaleItem(user.getOrder().getPorProductSaleList().getSaleItem(index));
           model2.removeElementAt(index);
           textField1.setText("Total: $" + user.getOrder().getPorProductSaleList().getTotalCost());
           list2.setModel(model2);
//           if(index != 0){
//               list2.setSelectedIndex(index - 1);
//           }
       }
       else{
           model2.setElementAt(user.getOrder().getPorProductSaleList().getSaleItem(index).getProduct().getCode() + " "
                   + user.getOrder().getPorProductSaleList().getSaleItem(index).getProduct().getDescription() + " $"
                   + user.getOrder().getPorProductSaleList().getSaleItem(index).getProduct().getPrice() + " "
                   + user.getOrder().getPorProductSaleList().getSaleItem(index).getQuantity(), index);
           textField1.setText("Total: $" + user.getOrder().getPorProductSaleList().getTotalCost());
           list2.setModel(model2);
           list2.setSelectedIndex(index);
       }
    }

    private void button3ActionPerformed(ActionEvent e) {
        if(user.getOrder() != null && user.getOrder().getPorProductSaleList().getNumberOfItems() != 0){
            int i;
            String info = "";
            productSaleList = new ProductSaleList();
            for(i = 0; i < user.getOrder().getPorProductSaleList().getNumberOfItems(); i++){
                productSaleList.addSaleItem(user.getOrder().getPorProductSaleList().getSaleItem(i));
            }
            order = new Order(productSaleList, 1);
            storeSale.addOrder(order);
            for(i = 0; i < order.getPorProductSaleList().getNumberOfItems(); i++){
                info += order.getPorProductSaleList().getSaleItem(i).getProduct().getCode()
                        + "(" + order.getPorProductSaleList().getSaleItem(i).getQuantity() + ")" + " ";
            }
            model3.addElement(info + order.getPorProductSaleList().getTotalCost());
            list3.setModel(model3);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label6 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        scrollPane3 = new JScrollPane();
        list2 = new JList();
        scrollPane4 = new JScrollPane();
        list3 = new JList();
        textField1 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[53,fill]" +
            "[51,fill]" +
            "[62,fill]" +
            "[51,fill]" +
            "[51,fill]" +
            "[52,fill]" +
            "[54,fill]" +
            "[55,fill]" +
            "[48,fill]" +
            "[54,fill]" +
            "[63,fill]" +
            "[55,fill]" +
            "[70,fill]" +
            "[38,fill]",
            // rows
            "[45]" +
            "[41]" +
            "[40]" +
            "[34]" +
            "[39]" +
            "[46]" +
            "[35]" +
            "[39]" +
            "[39]" +
            "[33]" +
            "[37]" +
            "[39]" +
            "[40]" +
            "[48]" +
            "[49]" +
            "[40]"));

        //---- label1 ----
        label1.setText("MilkSystem");
        label1.setFont(new Font("Consolas", Font.PLAIN, 32));
        contentPane.add(label1, "cell 1 0 3 2,alignx left,grow 0 100");

        //---- label6 ----
        label6.setText("UserName:");
        label6.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(label6, "cell 8 0");

        //---- textField2 ----
        textField2.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(textField2, "cell 9 0 2 1");

        //---- label2 ----
        label2.setText("Products");
        label2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label2, "cell 1 2 2 1,alignx left,grow 0 100");

        //---- label3 ----
        label3.setText("Current Product");
        label3.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label3, "cell 8 2 2 1,alignx left,grow 0 100");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setFont(new Font("Consolas", Font.PLAIN, 20));
            list1.addListSelectionListener(e -> list1ValueChanged(e));
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 1 3 4 3");

        //======== scrollPane2 ========
        {

            //---- textArea1 ----
            textArea1.setFont(new Font("Consolas", Font.PLAIN, 20));
            scrollPane2.setViewportView(textArea1);
        }
        contentPane.add(scrollPane2, "cell 8 3 3 3,grow");

        //---- button1 ----
        button1.setText("Add to Order");
        button1.setFont(new Font("Consolas", Font.PLAIN, 16));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 8 6 2 1");

        //---- label4 ----
        label4.setText("Current Order");
        label4.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label4, "cell 1 8 2 1,growy");

        //---- label5 ----
        label5.setText("Order History");
        label5.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(label5, "cell 8 8 2 1,growy");

        //======== scrollPane3 ========
        {

            //---- list2 ----
            list2.setFont(new Font("Consolas", Font.PLAIN, 20));
            scrollPane3.setViewportView(list2);
        }
        contentPane.add(scrollPane3, "cell 1 9 4 5,growy");

        //======== scrollPane4 ========
        {

            //---- list3 ----
            list3.setFont(new Font("Consolas", Font.PLAIN, 20));
            scrollPane4.setViewportView(list3);
        }
        contentPane.add(scrollPane4, "cell 8 9 3 5,growy");

        //---- textField1 ----
        textField1.setText("Total: $0");
        textField1.setFont(new Font("Consolas", Font.PLAIN, 18));
        contentPane.add(textField1, "cell 1 14 4 1");

        //---- button2 ----
        button2.setText("Remove product");
        button2.setFont(new Font("Consolas", Font.PLAIN, 16));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 1 15 3 1");

        //---- button3 ----
        button3.setText("Submit order");
        button3.setFont(new Font("Consolas", Font.PLAIN, 16));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3, "cell 5 15 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JList list1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JButton button1;
    private JLabel label4;
    private JLabel label5;
    private JScrollPane scrollPane3;
    private JList list2;
    private JScrollPane scrollPane4;
    private JList list3;
    private JTextField textField1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
