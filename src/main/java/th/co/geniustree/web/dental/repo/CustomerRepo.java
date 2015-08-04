/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.web.dental.model.Customer;

/**
 *
 * @author Jasin007
 */
public interface CustomerRepo extends  JpaRepository<Customer, Integer>,JpaSpecificationExecutor<Customer>{
    
}
