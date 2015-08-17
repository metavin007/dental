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
import th.co.geniustree.web.dental.model.TypeProduct;
import th.co.geniustree.web.dental.repo.TypeProductRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class TypeProductController {

    @Autowired
    TypeProductRepo typeProductRepo;
    
    @RequestMapping(value = "/loadtypeproduct")
    public Page<TypeProduct> loadTypeProduct(Pageable pageable){
        return typeProductRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savetypeproduct",method = RequestMethod.POST)
    public void saveTypeProduct(@Validated @RequestBody TypeProduct typeProduct){
        typeProductRepo.save(typeProduct);
    }
    
    @RequestMapping(value = "/deletetypeproduct",method = RequestMethod.POST)
    public void deleteTypeProduct(@RequestBody TypeProduct typeProduct){
        typeProductRepo.delete(typeProduct.getId());
    }
}
