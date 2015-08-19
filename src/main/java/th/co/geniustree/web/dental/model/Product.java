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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jasin007
 */
@Entity
public class Product implements Serializable {

    @Id
    @SequenceGenerator(name = "PRODUCT", sequenceName = "PRODUCT_SQE", allocationSize = 1)
    @GeneratedValue(generator = "PRODUCT", strategy = GenerationType.AUTO)
    private Integer Id;

    @NotBlank(message = "Name not Empty")
    @Column(name = "NAME")
    private String name;

    @Column(name = "BARCODE_MAIN")
    private String barCode_Main;

    @Column(name = "BARCODE_SUB")
    private String barCode_Sub;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRE")
    private Date expire;

    @ManyToOne
    @JoinColumn(name = "TYPEPRODUCT_ID")
    private TypeProduct typeProduct;

    @ManyToOne
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;

    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<PriceProduct> priceProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<ValueProduct> valueProducts;

    public List<PriceProduct> getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(List<PriceProduct> priceProducts) {
        this.priceProducts = priceProducts;
    }

    public List<ValueProduct> getValueProducts() {
        return valueProducts;
    }

    public void setValueProducts(List<ValueProduct> valueProducts) {
        this.valueProducts = valueProducts;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode_Main() {
        return barCode_Main;
    }

    public void setBarCode_Main(String barCode_Main) {
        this.barCode_Main = barCode_Main;
    }

    public String getBarCode_Sub() {
        return barCode_Sub;
    }

    public void setBarCode_Sub(String barCode_Sub) {
        this.barCode_Sub = barCode_Sub;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.Id);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

}
