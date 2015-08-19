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
import th.co.geniustree.web.dental.model.PriceProduct;
import th.co.geniustree.web.dental.repo.PriceProductRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class PriceController {
    
    @Autowired
    private PriceProductRepo priceProductRepo;
    
    @RequestMapping(value = "/loadprice")
    public Page<PriceProduct> loadPriceProduct(Pageable pageable){
        return priceProductRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/saveprice",method = RequestMethod.POST)
    public void savePriceProduct(@Validated @RequestBody PriceProduct priceProduct){
        priceProductRepo.save(priceProduct);
    }
    
    @RequestMapping(value = "/deleteprice",method = RequestMethod.POST)
    public void deletePriceProduct(@RequestBody PriceProduct priceProduct){
        priceProductRepo.delete(priceProduct.getId());
    }
    
}
