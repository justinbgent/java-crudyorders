package com.schoolwork.agentordersproject;

import com.schoolwork.agentordersproject.model.Agent;
import com.schoolwork.agentordersproject.model.Customer;
import com.schoolwork.agentordersproject.model.Order;
import com.schoolwork.agentordersproject.model.Payment;
import com.schoolwork.agentordersproject.repos.CustomerRepo;
import com.schoolwork.agentordersproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
//@Component
//public class SeedData implements CommandLineRunner
//{
//    @Autowired
//    private Service service;
//
//    @Override
//    public void run(String[] args) throws Exception
//    {
//        Payment pay1 = new Payment("Cash");
//        Payment pay2 = new Payment("Gift Card");
//        Payment pay3 = new Payment("Credit Card");
//        Payment pay4 = new Payment("Mobile Pay");
//
////        pay1 = paymentrepos.save(pay1);
////        pay2 = paymentrepos.save(pay2);
////        pay3 = paymentrepos.save(pay3);
////        pay4 = paymentrepos.save(pay4);
//
//        Agent a01 = new Agent("Ramasundar", "Bangalore", 0.15, "077-25814763", "");
//        Agent a02 = new Agent("Alex", "London", 0.13, "075-12458969", "");
//        Agent a03 = new Agent("Alford", "New York", 0.12, "044-25874365", "");
//        Agent a04 = new Agent("Ravi", "Bangalore", 0.15, "077-45625874", "");
//        Agent a05 = new Agent("Santakumar", "Chennai", 0.14, "007-22388644", "");
//        Agent a06 = new Agent("Lucida", "San Jose", 0.12, "044-52981425", "");
//        Agent a07 = new Agent("Anderson", "Brisban", 0.13, "045-21447739", "");
//        Agent a08 = new Agent("Subbarao", "Bangalore", 0.14, "077-12346674", "");
//        Agent a09 = new Agent("Mukesh", "Mumbai", 0.11, "029-12358964", "");
//        Agent a10 = new Agent("McDen", "London", 0.15, "078-22255588", "");
//        Agent a11 = new Agent("Ivan", "Torento", 0.15, "008-22544166", "");
//        Agent a12 = new Agent("Benjamin", "Hampshair", 0.11, "008-22536178", "");
//
//        Customer c01 = new Customer("Holmes", "London", "London", "UK", "2", 6000.00, 5000.00, 7000.00, 4000.00, "BBBBBBB", a03);
//        Customer c02 = new Customer("Micheal", "New York", "New York", "USA", "2", 3000.00, 5000.00, 2000.00, 6000.00, "CCCCCCC", a08);
//        Customer c03 = new Customer("Albert", "New York", "New York", "USA", "3", 5000.00, 7000.00, 6000.00, 6000.00, "BBBBSBB", a08);
//        Customer c04 = new Customer("Ravindran", "Bangalore", "Bangalore", "India", "2", 5000.00, 7000.00, 4000.00, 8000.00, "AVAVAVA", a11);
//        Customer c05 = new Customer("Cook", "London", "London", "UK", "2", 4000.00, 9000.00, 7000.00, 6000.00, "FSDDSDF", a06);
//        Customer c06 = new Customer("Stuart", "London", "London", "UK", "1", 6000.00, 8000.00, 3000.00, 11000.00, "GFSGERS", a03);
//        Customer c07 = new Customer("Bolt", "New York", "New York", "USA", "3", 5000.00, 7000.00, 9000.00, 3000.00, "DDNRDRH", a08);
//        Customer c08 = new Customer("Fleming", "Brisban", "Brisban", "Australia", "2", 7000.00, 7000.00, 9000.00, 5000.00, "NHBGVFC", a05);
//        Customer c09 = new Customer("Jacks", "Brisban", "Brisban", "Australia", "1", 7000.00, 7000.00, 7000.00, 7000.00, "WERTGDF", a05);
//        Customer c10 = new Customer("Yearannaidu", "Chennai", "Chennai", "India", "1", 8000.00, 7000.00, 7000.00, 8000.00, "ZZZZBFV", a10);
//        Customer c11 = new Customer("Sasikant", "Mumbai", "Mumbai", "India", "1", 7000.00, 11000.00, 7000.00, 11000.00, "147-25896312", a02);
//        Customer c12 = new Customer("Ramanathan", "Chennai", "Chennai", "India", "1", 7000.00, 11000.00, 9000.00, 9000.00, "GHRDWSD", a10);
//        Customer c13 = new Customer("Avinash", "Mumbai", "Mumbai", "India", "2", 7000.00, 11000.00, 9000.00, 9000.00, "113-12345678", a02);
//        Customer c14 = new Customer("Winston", "Brisban", "Brisban", "Australia", "1", 5000.00, 8000.00, 7000.00, 6000.00, "AAAAAAA", a05);
//        Customer c15 = new Customer("Karl", "London", "London", "UK", "0", 4000.00, 6000.00, 7000.00, 3000.00, "AAAABAA", a06);
//        Customer c16 = new Customer("Shilton", "Torento", "Torento", "Canada", "1", 10000.00, 7000.00, 6000.00, 11000.00, "DDDDDDD", a04);
//        Customer c17 = new Customer("Charles", "Hampshair", "Hampshair", "UK", "3", 6000.00, 4000.00, 5000.00, 5000.00, "MMMMMMM", a09);
//        Customer c18 = new Customer("Srinivas", "Bangalore", "Bangalore", "India", "2", 8000.00, 4000.00, 3000.00, 9000.00, "AAAAAAB", a07);
//        Customer c19 = new Customer("Steven", "San Jose", "San Jose", "USA", "1", 5000.00, 7000.00, 9000.00, 3000.00, "KRFYGJK", a10);
//        Customer c20 = new Customer("Karolina", "Torento", "Torento", "Canada", "1", 7000.00, 7000.00, 9000.00, 5000.00, "HJKORED", a04);
//        Customer c21 = new Customer("Martin", "Torento", "Torento", "Canada", "2", 8000.00, 7000.00, 7000.00, 8000.00, "MJYURFD", a04);
//        Customer c22 = new Customer("Ramesh", "Mumbai", "Mumbai", "India", "3", 8000.00, 7000.00, 3000.00, 12000.00, "Phone No", a02);
//        Customer c23 = new Customer("Rangarappa", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "AAAATGF", a01);
//        Customer c24 = new Customer("Venkatpati", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "JRTVFDD", a07);
//        Customer c25 = new Customer("Sundariya", "Chennai", "Chennai", "India", "3", 7000.00, 11000.00, 7000.00, 11000.00, "PPHGRTS", a10);
//
//        Order o01 = new Order(1000.00, 600.00, "SOD", c13);
////        o01.addPayments(pay1);
//
//        Order o02 = new Order(3000.00, 500.00, "SOD", c19);
////        o02.addPayments(pay2);
//
//        Order o03 = new Order(4500.00, 900.00, "SOD", c07);
////        o03.addPayments(pay3);
////        o03.addPayments(pay2);
//
//        Order o04 = new Order(2000.00, 0.00, "SOD", c16);
////        o04.addPayments(pay4);
//
//        Order o05 = new Order(4000.00, 600.00, "SOD", c22);
////        o05.addPayments(pay2);
//
//        Order o06 = new Order(2000.00, 0.00, "SOD", c12);
////        o06.addPayments(pay3);
//
//        Order o07 = new Order(3500.00, 2000.00, "SOD", c02);
////        o07.addPayments(pay4);
//
//        Order o08 = new Order(2500.00, 400.00, "SOD", c03);
////        o08.addPayments(pay1);
//
//        Order o09 = new Order(500.00, 0.00, "SOD", c23);
////        o09.addPayments(pay3);
//
//        Order o10 = new Order(4000.00, 700.00, "SOD", c07);
////        o10.addPayments(pay4);
//
//        Order o11 = new Order(1500.00, 600.00, "SOD", c08);
////        o11.addPayments(pay2);
//
//        Order o12 = new Order(2500.00, 0.00, "SOD", c25);
////        o12.addPayments(pay1);
//
//        service.saveAgent(a01);
//        service.saveAgent(a02);
//        service.saveAgent(a03);
//        service.saveAgent(a04);
//        service.saveAgent(a05);
//        service.saveAgent(a06);
//        service.saveAgent(a07);
//        service.saveAgent(a08);
//        service.saveAgent(a09);
//        service.saveAgent(a10);
//        service.saveAgent(a11);
//        service.saveAgent(a12);
//
//        service.saveCustomer(c01);
//        service.saveCustomer(c02);
//        service.saveCustomer(c03);
//        service.saveCustomer(c04);
//        service.saveCustomer(c05);
//        service.saveCustomer(c06);
//        service.saveCustomer(c07);
//        service.saveCustomer(c08);
//        service.saveCustomer(c09);
//        service.saveCustomer(c10);
//        service.saveCustomer(c11);
//        service.saveCustomer(c12);
//        service.saveCustomer(c13);
//        service.saveCustomer(c14);
//        service.saveCustomer(c15);
//        service.saveCustomer(c16);
//        service.saveCustomer(c17);
//        service.saveCustomer(c18);
//        service.saveCustomer(c19);
//        service.saveCustomer(c20);
//        service.saveCustomer(c21);
//        service.saveCustomer(c22);
//        service.saveCustomer(c23);
//        service.saveCustomer(c24);
//        service.saveCustomer(c25);
//
//        service.saveOrder(o01);
//        service.saveOrder(o02);
//        service.saveOrder(o03);
//        service.saveOrder(o04);
//        service.saveOrder(o05);
//        service.saveOrder(o06);
//        service.saveOrder(o07);
//        service.saveOrder(o08);
//        service.saveOrder(o09);
//        service.saveOrder(o10);
//        service.saveOrder(o11);
//        service.saveOrder(o12);
//    }
//}
