/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.cotroller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.web.dental.model.Customer;
import th.co.geniustree.web.dental.model.MedicalHistory;
import th.co.geniustree.web.dental.repo.CustomerRepo;
import th.co.geniustree.web.dental.repo.MedicalHistoryRepo;
import th.co.geniustree.web.dental.specification.CustomerSpec;

/**
 *
 * @author Jasin007
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;
    
    private Customer selectCustomer;

//    @Autowired
//    private CustomerService custumerService;
    @RequestMapping(value = "/customer")
    public Page<Customer> getCustomer(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void saveCustomer(@Validated @RequestBody Customer customer) {
        customerRepo.save(customer);
    }

    @RequestMapping(value = "/customerdelete", method = RequestMethod.POST)
    public void deleteCutomer(@RequestBody Customer customer) {
//        Customer cus = custumerService.findByName("John");
        customerRepo.delete(customer.getId());
    }
    
    
    @RequestMapping(value = "/selectdetailcustomer",method = RequestMethod.POST)
    public void selectDetailCustomer(@RequestBody Customer customer){
        selectCustomer = customer;
    }
    
    @RequestMapping(value = "/loaddetailcustomer")
    public Page<Customer> loaddetailcustomer(Pageable pageable){
        while(selectCustomer == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return  customerRepo.findByEmail(selectCustomer.getEmail(), pageable);
    }
    

    @RequestMapping(value = "/medicalhistory")
    public Page<MedicalHistory> getMedicalHistory(Pageable pageable) {
        return medicalHistoryRepo.findAll(pageable);
    }

    @RequestMapping(value = "/customer/search",method = RequestMethod.POST)
    public Page<Customer> searchCustomer(String keyword, Pageable pageable) {
        Specifications<Customer> specification = Specifications.where(CustomerSpec.likeName("%"+keyword+"%"))
                .or(CustomerSpec.likeEmail("%"+keyword+"%"));
        return customerRepo.findAll(specification, pageable);
    }
}
