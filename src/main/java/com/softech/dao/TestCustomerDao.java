package com.softech.dao;

import com.softech.entities.Customer;

import java.text.ParseException;

public class TestCustomerDao {

    public static void main(String[] args) throws ParseException {
        CustomerDAO customerDAO = new CustomerDAO();

//        Customer customer = new Customer(1,"hanh", "phan thiet");
//        Customer customer2 = new Customer("ha", "gia lai");
        Customer customer3 = new Customer(7,"binh", "lao cai");
//
//        customerDAO.insert(customer);
//        customerDAO.insert(customer2);
//        customerDAO.insert(customer3);

        System.out.println("----------Show All---------");
        customerDAO.showAll();
        System.out.println("-------update---------");
//        customerDAO.delete(4);
//        customerDAO.updateName(1,"huy");
//        customerDAO.updateAll(customer);
//        customerDAO.showAll();
        System.out.println("---------search---------");
        customerDAO.searchByName("binh");

        System.out.println("ok");

    }
}
