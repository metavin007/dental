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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "ORDERBILL")
public class OrderBill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "VALUE")
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "BILL_ID")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_LOT_ID")
    private Product_Lot product_Lot;

    @OneToOne
    @JoinColumn(name = "DETAILHEAL_ID")
    private DetailHeal detailHeal;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product_Lot getProduct_Lot() {
        return product_Lot;
    }

    public void setProduct_Lot(Product_Lot product_Lot) {
        this.product_Lot = product_Lot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public DetailHeal getDetailHeal() {
        return detailHeal;
    }

    public void setDetailHeal(DetailHeal detailHeal) {
        this.detailHeal = detailHeal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final OrderBill other = (OrderBill) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
