package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by wangy on 2016-12-19.
 */
@Entity
@Table(name = "laoren")
public class Laoren {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String nation;
    private String birthday;
    private String idnumber;
    private String address;
    private String phone;
    private String mobile;
    private Integer createuser;
    private String createtime;
    private String createusername;
    private Integer type;
    private String bingshi;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 255)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "nation", nullable = true, length = 255)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "birthday", nullable = true, length = 255)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "idnumber", nullable = true, length = 18)
    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 11)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "createuser", nullable = true)
    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    @Basic
    @Column(name = "createtime", nullable = true, length = 255)
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "createusername", nullable = true, length = 255)
    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "bingshi", nullable = true, length = 255)
    public String getBingshi() {
        return bingshi;
    }

    public void setBingshi(String bingshi) {
        this.bingshi = bingshi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laoren laoren = (Laoren) o;

        if (id != null ? !id.equals(laoren.id) : laoren.id != null) return false;
        if (name != null ? !name.equals(laoren.name) : laoren.name != null) return false;
        if (sex != null ? !sex.equals(laoren.sex) : laoren.sex != null) return false;
        if (age != null ? !age.equals(laoren.age) : laoren.age != null) return false;
        if (nation != null ? !nation.equals(laoren.nation) : laoren.nation != null) return false;
        if (birthday != null ? !birthday.equals(laoren.birthday) : laoren.birthday != null) return false;
        if (idnumber != null ? !idnumber.equals(laoren.idnumber) : laoren.idnumber != null) return false;
        if (address != null ? !address.equals(laoren.address) : laoren.address != null) return false;
        if (phone != null ? !phone.equals(laoren.phone) : laoren.phone != null) return false;
        if (mobile != null ? !mobile.equals(laoren.mobile) : laoren.mobile != null) return false;
        if (createuser != null ? !createuser.equals(laoren.createuser) : laoren.createuser != null) return false;
        if (createtime != null ? !createtime.equals(laoren.createtime) : laoren.createtime != null) return false;
        if (createusername != null ? !createusername.equals(laoren.createusername) : laoren.createusername != null) return false;
        if (type != null ? !type.equals(laoren.type) : laoren.type != null) return false;
        if (bingshi != null ? !bingshi.equals(laoren.bingshi) : laoren.bingshi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (idnumber != null ? idnumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (createusername != null ? createusername.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (bingshi != null ? bingshi.hashCode() : 0);
        return result;
    }
}
