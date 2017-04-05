package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by wangy on 2016-12-19.
 */
@Entity
@Table(name = "tableinfo")
public class Tableinfo {
    private Integer id;
    private String tablename;
    private String columnname;
    private String chinese;
    private Integer tabledisable;
    private Integer modaldisable;
    private String type;
    private Integer shunxu;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tablename")
    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    @Basic
    @Column(name = "columnname")
    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    @Basic
    @Column(name = "chinese")
    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Basic
    @Column(name = "tabledisable")
    public Integer getTabledisable() {
        return tabledisable;
    }

    public void setTabledisable(Integer tabledisable) {
        this.tabledisable = tabledisable;
    }

    @Basic
    @Column(name = "modaldisable")
    public Integer getModaldisable() {
        return modaldisable;
    }

    public void setModaldisable(Integer modaldisable) {
        this.modaldisable = modaldisable;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "shunxu")
    public Integer getShunxu() {
        return shunxu;
    }

    public void setShunxu(Integer shunxu) {
        this.shunxu = shunxu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tableinfo tableinfo = (Tableinfo) o;

        if (id != null ? !id.equals(tableinfo.id) : tableinfo.id != null) return false;
        if (tablename != null ? !tablename.equals(tableinfo.tablename) : tableinfo.tablename != null) return false;
        if (columnname != null ? !columnname.equals(tableinfo.columnname) : tableinfo.columnname != null) return false;
        if (chinese != null ? !chinese.equals(tableinfo.chinese) : tableinfo.chinese != null) return false;
        if (tabledisable != null ? !tabledisable.equals(tableinfo.tabledisable) : tableinfo.tabledisable != null) return false;
        if (modaldisable != null ? !modaldisable.equals(tableinfo.modaldisable) : tableinfo.modaldisable != null) return false;
        if (type != null ? !type.equals(tableinfo.type) : tableinfo.type != null) return false;
        if (shunxu != null ? !shunxu.equals(tableinfo.shunxu) : tableinfo.shunxu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tablename != null ? tablename.hashCode() : 0);
        result = 31 * result + (columnname != null ? columnname.hashCode() : 0);
        result = 31 * result + (chinese != null ? chinese.hashCode() : 0);
        result = 31 * result + (tabledisable != null ? tabledisable.hashCode() : 0);
        result = 31 * result + (modaldisable != null ? modaldisable.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shunxu != null ? shunxu.hashCode() : 0);
        return result;
    }
}
