package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by wangyong on 1/5/17.
 */
@Entity
@Table(name = "platform")
public class Platform {
    private Integer id;
    private String name;
    private String url;
    private Integer use;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "use")
    public Integer getUse() {
        return use;
    }

    public void setUse(Integer use) {
        this.use = use;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform = (Platform) o;

        if (id != null ? !id.equals(platform.id) : platform.id != null) return false;
        if (name != null ? !name.equals(platform.name) : platform.name != null) return false;
        if (url != null ? !url.equals(platform.url) : platform.url != null) return false;
        if (use != null ? !use.equals(platform.use) : platform.use != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (use != null ? use.hashCode() : 0);
        return result;
    }
}
