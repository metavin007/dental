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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "NOTICEDETAILPAYMAIN")
public class NoticeDetailPayMain implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    
    @Column(name = "CODEPAY")
    private String codePay;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAPRICE")
    private Date dataPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodePay() {
        return codePay;
    }

    public void setCodePay(String codePay) {
        this.codePay = codePay;
    }

    public Date getDataPrice() {
        return dataPrice;
    }

    public void setDataPrice(Date dataPrice) {
        this.dataPrice = dataPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final NoticeDetailPayMain other = (NoticeDetailPayMain) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
