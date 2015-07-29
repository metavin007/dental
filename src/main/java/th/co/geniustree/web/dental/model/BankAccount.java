/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "BANKACCOUNT")
public class BankAccount implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "ADDCOUNT_ID")
    private String addcountid;
    
    @Column(name = "ADDCOUNT_NAME")
    private String addcountname;
    
    @Column(name = "BANK_NAME")
    private String bankname;
    
    @Column(name = "ADDCOUNT_TYPE")
    private String addcounttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddcountid() {
        return addcountid;
    }

    public void setAddcountid(String addcountid) {
        this.addcountid = addcountid;
    }

    public String getAddcountname() {
        return addcountname;
    }

    public void setAddcountname(String addcountname) {
        this.addcountname = addcountname;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAddcounttype() {
        return addcounttype;
    }

    public void setAddcounttype(String addcounttype) {
        this.addcounttype = addcounttype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final BankAccount other = (BankAccount) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
