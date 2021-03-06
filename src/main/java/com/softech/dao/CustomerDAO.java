package com.softech.dao;

import com.softech.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    void insert(Customer customer){
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            System.out.println("insert success");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public Customer findById(int id){
        Session session = sessionFactory.openSession();
        Customer customer = session.load(Customer.class, id);
        System.out.println(customer);
        return customer;
    }

    void showAll(){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Customer> list = session.createQuery("from Customer").list();
            for (Customer customer: list){
                System.out.println(customer);
            }
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    void updateName(int id, String name){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hqlUpdate = "update Customer u set u.name = :newName where u.id = :oldId";

            session.createQuery(hqlUpdate).setString("newName", name).setInteger("oldId", id).executeUpdate();
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    void updateAll(Customer customer){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    void delete(int id){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Customer customer = session.load(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
            System.out.println("delete success");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    void searchByName(String name){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Customer> list = session.createQuery("from Customer where name like :name").setParameter("name", "%" + name + "%").list();
            for(Customer customer : list){
                System.out.println(customer);
            }
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
