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
import th.co.geniustree.web.dental.model.Authority;
import th.co.geniustree.web.dental.model.Staff;
import th.co.geniustree.web.dental.repo.AuthorityRepo;
import th.co.geniustree.web.dental.repo.StaffRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class StaffController {
    
    @Autowired
    StaffRepo staffRepo;   
    
    @RequestMapping(value = "/loadstaff")
    public Page<Staff> loadStaff(Pageable pageable){
        return staffRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
    public void saveStaff(@Validated @RequestBody Staff staff){
        staffRepo.save(staff);
    }
    
    @RequestMapping(value = "/deleteStaff" , method = RequestMethod.POST)
    public void deleteStaff(@RequestBody Staff staff){
        staffRepo.delete(staff.getId());
    }
        
            
}
