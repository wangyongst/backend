package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by BHWL on 2016-12-23.
 */
@Entity
@Table(name = "video")
public class Video {
    private Integer id;
    private String url;
    private Integer home;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        if (id != null ? !id.equals(video.id) : video.id != null) return false;
        if (url != null ? !url.equals(video.url) : video.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "home")
    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }
}
