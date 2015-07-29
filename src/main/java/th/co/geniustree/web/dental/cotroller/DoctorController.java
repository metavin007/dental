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
import th.co.geniustree.web.dental.model.Doctor;
import th.co.geniustree.web.dental.repo.DoctorRepo;

/**
 *
 * @author Jasin007
 */
@RestController
public class DoctorController {

    @Autowired
    DoctorRepo doctorRepo;

    @RequestMapping(value = "/loaddoctor")
    public Page<Doctor> loafDoctor(Pageable pageable){
        return doctorRepo.findAll(pageable);
    } 
    
    @RequestMapping(value = "/savedoctor" , method = RequestMethod.POST)
    public void saveDoctor(@Validated @RequestBody Doctor doctor){
        doctorRepo.save(doctor);
    }
    
    @RequestMapping(value = "/deletedoctor" , method = RequestMethod.POST)
    public void deleteDoctor(@RequestBody Doctor doctor){
        doctorRepo.delete(doctor.getId());
    }
}
