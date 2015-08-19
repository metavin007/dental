/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.web.dental.model.Product_Lot;

/**
 *
 * @author Jasin007
 */
public interface Product_LotRepo extends JpaRepository<Product_Lot, Integer>{
    
}
