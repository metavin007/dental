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
@Table(name = "PAYHEAL")
public class PayHeal implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "PRICEPAYNAME")
    private Double pricePayname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPricePayname() {
        return pricePayname;
    }

    public void setPricePayname(Double pricePayname) {
        this.pricePayname = pricePayname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final PayHeal other = (PayHeal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
