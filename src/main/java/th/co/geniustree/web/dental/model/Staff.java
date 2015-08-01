/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.web.dental.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "STAFF")
@AttributeOverride(name = "stateEmployee", column = @Column(name = "STATA_STAFF"))
public class Staff extends SuperEmployee implements Serializable {

    @NotBlank(message = "E-Mail not Empty")
    @Email(message = "format Incompatible (Ex. xxx@xxx.com)")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PID")
    private String pid;

    @NotBlank(message = "Name not Empty")
    @Column(name = "NAMETH")
    private String nameTh;

    @Column(name = "NAMEENG")
    private String nameEng;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthDay;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "BLOOD")
    private String blood;

    @Column(name = "SOLDIERSTATUS")
    private String soldierStatus;

    @Column(name = "MARRYSTATUS")
    private String marryStatus;

    @Column(name = "NATION")
    private String nation;

    @Column(name = "RACE")
    private String race;

    @Column(name = "ADDRESSPID")
    private String addressPid;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TEL")
    private String tel;

    @NotBlank(message = "Mobile not Empty")
    @Column(name = "MOBILE")
    private String mobile;

    @Temporal(TemporalType.DATE)
    @Column(name = "STARTWORD")
    private Date startWork;

    @Temporal(TemporalType.DATE)
    @Column(name = "ENDWORD")
    private Date endWork;

    @Column(name = "WORD_STATUS")
    private String workStatus;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENTEMPLOYEE_ID")
    private DepartmentEmployee departmentEmployee;

    public DepartmentEmployee getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }

    private boolean enabled = true;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public String getSoldierStatus() {
        return soldierStatus;
    }

    public void setSoldierStatus(String soldierStatus) {
        this.soldierStatus = soldierStatus;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
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

    public String getAddressPid() {
        return addressPid;
    }

    public void setAddressPid(String addressPid) {
        this.addressPid = addressPid;
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

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public Date getEndWork() {
        return endWork;
    }

    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
