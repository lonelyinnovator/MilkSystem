package com.milkSystem.java;

public class User {

    private Order order;
    private String usrName;
    private String password;
    private String email;



    public User(String initialUsrName, String initialPassword, String initialEmail, Order initialOrder){
        usrName = initialUsrName;
        password = initialPassword;
        email = initialEmail;
        order = initialOrder;
    }

    public User(){

    }


    public String getUsrName() {
        return usrName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Order getOrder() {
        return order;
    }

    public void  setOrder(Order order){
        this.order = order;
    }
}
