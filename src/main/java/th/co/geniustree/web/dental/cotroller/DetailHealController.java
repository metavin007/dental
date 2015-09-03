 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.cotroller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.web.dental.model.DetailHeal;
import th.co.geniustree.web.dental.model.PayHeal;
import th.co.geniustree.web.dental.repo.DetailHealRepo;
import th.co.geniustree.web.dental.repo.PayHealRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class DetailHealController {

    @Autowired
    private DetailHealRepo detailHealRepo;
    
    @Autowired
    private PayHealRepo payHealRepo;
    
   
    

    @RequestMapping(value = "/loaddetailheal")
    public Page<DetailHeal> loadDetailHeal(Pageable pageable) {
        return detailHealRepo.findAll(pageable);
    }

    @RequestMapping(value = "/savedetailheal", method = RequestMethod.POST)
    public void saveDetailHeal(@RequestBody DetailHeal detailHeal,PayHeal[] payHeals){
        detailHealRepo.save(detailHeal);  
        for(int i = 0 ; i < payHeals.length ; i ++ ){
           payHealRepo.save(payHeals[i]); 
        }  
    }

    @RequestMapping(value = "/deletedetailheal", method = RequestMethod.POST)
    public void deleteDetailHeal(@RequestBody DetailHeal detailHeal) {
        detailHealRepo.delete(detailHeal.getId());
    }

}
