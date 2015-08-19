/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "LOT")
public class Lot implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATEINPRODUCT")
    private Date dateInProduct;
    
    @Column(name = "DATEOUTPRODUCT")
    @Temporal(TemporalType.DATE)
    private Date dateOutProduct;
    
    @Column(name = "NAMESAFFREAM")
    private String nameSaffReam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateInProduct() {
        return dateInProduct;
    }

    public void setDateInProduct(Date dateInProduct) {
        this.dateInProduct = dateInProduct;
    }

    public Date getDateOutProduct() {
        return dateOutProduct;
    }

    public void setDateOutProduct(Date dateOutProduct) {
        this.dateOutProduct = dateOutProduct;
    }

    public String getNameSaffReam() {
        return nameSaffReam;
    }

    public void setNameSaffReam(String nameSaffReam) {
        this.nameSaffReam = nameSaffReam;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Lot other = (Lot) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
