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
@Table(name = "PRICEPRODUCT")
public class PriceProduct implements Serializable {

    @Id
    @SequenceGenerator(name = "PRICEPRODUCT", sequenceName = "PRICEPRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "PRICEPRODUCT", strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PRICE")
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date create_Date;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final PriceProduct other = (PriceProduct) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
