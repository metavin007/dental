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
import th.co.geniustree.web.dental.model.PayHeal;
import th.co.geniustree.web.dental.repo.PayHealRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class PayHealController {

    @Autowired
    private PayHealRepo payHealRepo;

    @RequestMapping(value = "/loadpayheal")
    public Page<PayHeal> loadDetailHeal(Pageable pageable) {
        return payHealRepo.findAll(pageable);
    }

    @RequestMapping(value = "/savepayheal", method = RequestMethod.POST)
    public void saveDetailHeal(@Validated @RequestBody PayHeal payHeal) { 
        System.out.println("------------------------------>"+payHeal.toString());
        System.out.println("--------------------------------->"+payHeal.getListPayHeal());
        System.out.println("--------------------------------->"+payHeal.getValue());
        payHealRepo.save(payHeal);
    }

    @RequestMapping(value = "/deletepayheal", method = RequestMethod.POST)
    public void deleteDetailHeal(@RequestBody PayHeal payHeal) {
        payHealRepo.delete(payHeal.getId());
    }

}
