/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.web.dental.model.Product_Lot;
import th.co.geniustree.web.dental.repo.Product_LotRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class Product_LotController {
    
    @Autowired
    private Product_LotRepo product_LotRepo;
    
    @RequestMapping(value = "/loadproductlot")
    public Page<Product_Lot> loadProductLot(Pageable pageable){
        return product_LotRepo.findAll(pageable);
    }
    
    @RequestMapping(value =  "/saveproductlot",method = RequestMethod.POST)
    public void saveProductLot(@Validated @RequestBody Product_Lot product_Lot){
        product_LotRepo.save(product_Lot);
    }
    
    @RequestMapping(value =  "/deleteductlot" , method = RequestMethod.POST)
    public void deleteProductLot(@RequestBody Product_Lot product_Lot){
        product_LotRepo.delete(product_Lot.getId());
    }
}
