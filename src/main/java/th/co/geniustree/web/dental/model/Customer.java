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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jasin007
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @SequenceGenerator(name = "CUSTOMER", sequenceName = "CUTOMER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CUSTOMER", strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "HN")
    private String hn;

    @Column(name = "PID")
    private String pid;

    @NotBlank(message = "Name not Empty")
    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "BLOOD")
    private String blood;

    @Column(name = "NATION")
    private String nation;

    @Column(name = "RACE")
    private String race;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TEL")
    private String tel;

    @NotBlank(message = "Mobile not Empty")
    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "JOB")
    private String job;

    @NotBlank(message = "E-Mail not Empty")
    @Email(message = "format Incompatible (Ex. xxx@xxx.com)")
    @Column(name = "EMAIL")
    private String email;

    @ManyToMany
    private List<MedicalHistory> medicalHistory;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<DetailHeal> detailHeals_Customer;

    public List<DetailHeal> getDetailHeals_Customer() {
        return detailHeals_Customer;
    }

    public void setDetailHeals_Customer(List<DetailHeal> detailHeals_Customer) {
        this.detailHeals_Customer = detailHeals_Customer;
    }

    public List<MedicalHistory> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<MedicalHistory> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHn() {
        return hn;
    }

    public void setHn(String hn) {
        this.hn = hn;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
