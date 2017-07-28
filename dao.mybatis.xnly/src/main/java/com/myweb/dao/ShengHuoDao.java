package com.myweb.dao;

import com.myweb.pojo.Fuwu;

import java.util.List;

public interface ShengHuoDao {

    public Fuwu getFuwuById(int id);

    public int saveFuwu(Fuwu fuwu);

    public int updateFuwuById(Fuwu fuwu);

    public List<Fuwu> findFuwus(Fuwu fuwu);

    public int deleteFuwuById(int id);
}