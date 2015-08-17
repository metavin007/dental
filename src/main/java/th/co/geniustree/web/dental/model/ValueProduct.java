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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "VALUEPRODUCT")
public class ValueProduct implements Serializable {

    @Id
    @SequenceGenerator(name = "VALUEPRODUCT", sequenceName = "VALUEPRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "VALUEPRODUCT", strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "VALUE")
    private Integer value;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_IN")
    private Date date_In;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_out")
    private Date date_out;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product products;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
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

    public Date getDate_In() {
        return date_In;
    }

    public void setDate_In(Date date_In) {
        this.date_In = date_In;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final ValueProduct other = (ValueProduct) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
