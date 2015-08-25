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
import th.co.geniustree.web.dental.model.Lot;
import th.co.geniustree.web.dental.repo.LotRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class LotController {
    
    @Autowired
    private LotRepo lotRepo;
    
    @RequestMapping(value = "/loadlot")
    public Page<Lot> loadLot(Pageable pageable){
        return lotRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savelot" ,method = RequestMethod.POST)
    public void saveLot(@Validated @RequestBody Lot lot){
        lotRepo.save(lot);
    }
    @RequestMapping(value = "/deletelot" ,method = RequestMethod.POST)
    public void deleteLot (@RequestBody Lot lot){
        lotRepo.delete(lot.getId());
    }
}
