/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.web.dental.model.Bill;
import th.co.geniustree.web.dental.model.OrderBill;
import th.co.geniustree.web.dental.model.PayHeal;
import th.co.geniustree.web.dental.model.Product_Lot;
import th.co.geniustree.web.dental.repo.BillRepo;
import th.co.geniustree.web.dental.repo.OrderBillRepo;
import th.co.geniustree.web.dental.repo.PayHealRepo;
import th.co.geniustree.web.dental.repo.Product_LotRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class BillController {

    @Autowired
    private OrderBillRepo orderBillRepo;

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private Product_LotRepo product_LotRepo;

    @Autowired
    private PayHealRepo payHealRepo;
    
    private Bill idBill;

    @RequestMapping(value = "/loadorderproduct")
    public Page<Product_Lot> loadOrderProduct(Pageable pageable) {
        return product_LotRepo.findAll(pageable);
    }

    @RequestMapping(value = "/loadbill")
    public Page<Bill> loadBill(Pageable pageable) {
        return billRepo.findAll(pageable);
    }

    @RequestMapping(value = "/loadpayheal")
    public Page<PayHeal> loadDetailHeal(Pageable pageable) {
        return payHealRepo.findAll(pageable);
    }

    @RequestMapping(value = "/savebill", method = RequestMethod.POST)
    public void saveBill(@RequestBody Bill bill) {
        billRepo.save(bill);
        idBill = bill;
    }

    @RequestMapping(value = "/saveorderbill", method = RequestMethod.POST)
    public void saveOrderBill(@RequestBody OrderBill[] orderBill) {
        for (OrderBill orderBill1 : orderBill) {
            orderBill1.setBill(idBill);
            orderBillRepo.save(orderBill1);
        }
    }
    
    @RequestMapping(value = "/saveidpayheal",method = RequestMethod.POST)
    public void saveIdPayheal(@RequestBody OrderBill orderBill){
        orderBill.setBill(idBill);
        orderBillRepo.save(orderBill);
    }

    @RequestMapping(value = "/deletebill", method = RequestMethod.POST)
    public void deleteBill(@RequestBody Bill bill) {
        billRepo.delete(bill.getId());
    }

}
