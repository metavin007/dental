/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Lot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATEIN")
    private Date dateIn;

    @Column(name = "DATEOUT")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    @Column(name = "NAMESAFFREAM")
    private String nameStaffReam;

    @JsonIgnore
    @OneToMany(mappedBy = "lot")
    private List<Product_Lot> product_Lots_Lot_Id;

    public List<Product_Lot> getProduct_Lots_Lot_Id() {
        return product_Lots_Lot_Id;
    }

    public void setProduct_Lots_Lot_Id(List<Product_Lot> product_Lots_Lot_Id) {
        this.product_Lots_Lot_Id = product_Lots_Lot_Id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getNameStaffReam() {
        return nameStaffReam;
    }

    public void setNameStaffReam(String nameStaffReam) {
        this.nameStaffReam = nameStaffReam;
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
