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
import th.co.geniustree.web.dental.model.Unit;
import th.co.geniustree.web.dental.repo.UnitRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class UnitController {

    @Autowired
    UnitRepo unitRepo;
    
    @RequestMapping(value = "/loadunit")
    public Page<Unit> loadUnit(Pageable pageable){
        return unitRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/saveunit",method = RequestMethod.POST)
    public void saveUnit(@Validated @RequestBody Unit unit){
       unitRepo.save(unit);
    }
    
    @RequestMapping(value = "/deleteunit",method = RequestMethod.POST)
    public void  deleteUnit(@RequestBody Unit unit){
        unitRepo.delete(unit.getId());
    }

}
