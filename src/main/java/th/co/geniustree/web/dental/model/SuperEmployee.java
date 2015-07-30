/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Jasin007
 */
@MappedSuperclass 
public abstract class SuperEmployee implements Serializable{
    
    @Id
    @SequenceGenerator(name = "SUPEREMPLOYEE", sequenceName = "SUPEREMPLOYEE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "SUPEREMPLOYEE",strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "STATEEMPLOYEE")
    private String stateEmployee;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANKACCOUNT_ID", nullable = true)
    private BankAccount bankaccount;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACTPERSON_ID", nullable = true)
    private ContactPersion contactpersion;
    
    @ManyToMany
    private List<Authority> authorities;

    public ContactPersion getContactpersion() {
        return contactpersion;
    }

    public void setContactpersion(ContactPersion contactpersion) {
        this.contactpersion = contactpersion;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public BankAccount getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(BankAccount bankaccount) {
        this.bankaccount = bankaccount;
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateEmployee() {
        return stateEmployee;
    }

    public void setStateEmployee(String stateEmployee) {
        this.stateEmployee = stateEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SuperEmployee other = (SuperEmployee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
