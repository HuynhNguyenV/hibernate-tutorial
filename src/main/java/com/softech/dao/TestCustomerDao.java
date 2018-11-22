package com.softech.dao;

import com.softech.entities.Customer;

import java.text.ParseException;

public class TestCustomerDao {

    public static void main(String[] args) {
        showAll();
//        findById();
    }

    public static void showAll(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.showAll();
    }


    public static void insert(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.insert(new Customer("kai","viet nam"));
    }

    public static void findById(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.findById(2);
    }

    public static void searchByName(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.searchByName("nga");
    }

    public static void delete(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.delete(4);
    }


}
