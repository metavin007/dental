/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.web.dental.App;
import th.co.geniustree.web.dental.model.BankAccount;
import th.co.geniustree.web.dental.model.ContactPersion;
import th.co.geniustree.web.dental.model.Staff;

import th.co.geniustree.web.dental.repo.StaffRepo;

/**
 *
 * @author Jasin007
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class MappingStaffTest {

    @Autowired
    StaffRepo staffRepo;

    @Test
    public void saveStaff() {
        Staff staff = new Staff();
        BankAccount bankAccount = new BankAccount();
        ContactPersion contactPersion = new ContactPersion();

        bankAccount.setAddcountname("xxxxx");
        bankAccount.setAddcounttype("yyyyy");
        bankAccount.setBankname("zzzzzz");

        contactPersion.setName("qqqqqq");
        contactPersion.setMobile("0000");
        contactPersion.setRelation("farther");

       

        staff.setNameTh("jasin");
        staff.setMobile("089111");
        staff.setBankaccount(bankAccount);
        staff.setContactpersion(contactPersion);

        staffRepo.save(staff);
    }

}
