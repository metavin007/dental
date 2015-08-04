/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.web.dental.model.Customer;
import th.co.geniustree.web.dental.model.Customer_;

/**
 *
 * @author Jasin007
 */
public class CustomerSpec {
    
    public static Specification<Customer> likeName(final String keyword){
        return  new Specification<Customer>() {

            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Customer_.name)), keyword.toUpperCase());
            }
        };
    }
    
    public static Specification<Customer> likeEmail(final String keyword) {
        return new Specification<Customer>() {

            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Customer_.email)),keyword.toUpperCase());
            }
        };
        
    }
    
}
