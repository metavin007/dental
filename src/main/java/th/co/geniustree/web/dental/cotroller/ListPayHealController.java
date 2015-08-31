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
import th.co.geniustree.web.dental.model.ListPayHeal;
import th.co.geniustree.web.dental.repo.ListPayHealRepo;

/**
 *
 * @author Jasin007
 */

@RestController
public class ListPayHealController {
    
    @Autowired
    private ListPayHealRepo listPayHealRepo;
    
    @RequestMapping(value = "/loadlistpayheal")
    public Page<ListPayHeal> loadListPayHeal(Pageable pageable){
        return listPayHealRepo.findAll(pageable);
    }
    
    @RequestMapping(value ="/savelistpayheal",method = RequestMethod.POST)
    public void saveListPayHeal(@Validated @RequestBody ListPayHeal listPayHeal){
        listPayHealRepo.save(listPayHeal);
    }
    
    @RequestMapping(value = "/deletelistpayheal",method = RequestMethod.POST)
    public void deleteListPayHeal(@RequestBody ListPayHeal listPayHeal){
        listPayHealRepo.delete(listPayHeal.getId());
    }
}
