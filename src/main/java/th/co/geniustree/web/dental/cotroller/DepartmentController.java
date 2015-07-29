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
import th.co.geniustree.web.dental.model.DepartmentEmployee;
import th.co.geniustree.web.dental.repo.DepartmentEmployeeRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentEmployeeRepo departmentEmployeeRepo;

    @RequestMapping(value = "/loaddepartmentemployee")
    public Page<DepartmentEmployee> loadDepartmentEmployee(Pageable pageable) {
        return departmentEmployeeRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savedepartmentemployee", method = RequestMethod.POST)
    public void saveDepartmentEmployee(@Validated @RequestBody DepartmentEmployee departmentEmployee){
        departmentEmployeeRepo.save(departmentEmployee);
    }
    
    @RequestMapping(value = "/deletedepartmentemployee", method = RequestMethod.POST)
    public void deleteDepartmentEmployee(@RequestBody DepartmentEmployee departmentEmployee){
        departmentEmployeeRepo.delete(departmentEmployee.getId());
    }
}
