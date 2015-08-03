///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.co.geniustree.web.dental.service.implement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import th.co.geniustree.web.dental.model.Customer;
//import th.co.geniustree.web.dental.repo.CustomerRepo;
//import th.co.geniustree.web.dental.service.CustomerService;
//
///**
// *
// * @author Jasin007
// */
//@Service
//@Transactional(propagation = Propagation.REQUIRED)
//public class CustomerServiceImplement implements CustomerService {
//
//    @Autowired
//    CustomerRepo customerRepo;
//
//    @Override
//    public Customer findByName(String name) {
//        return customerRepo.findOne(1);
//    }
//
//}
