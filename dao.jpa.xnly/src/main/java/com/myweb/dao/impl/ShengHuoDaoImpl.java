package com.myweb.dao.impl;

import com.myweb.dao.ShengHuoDao;
import com.myweb.dao.jpa.hibernate.FuwuRepository;
import com.myweb.pojo.Fuwu;
import com.myweb.util.DaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository("shengHuoDao")
public class ShengHuoDaoImpl implements ShengHuoDao {

    @Autowired
    private FuwuRepository fuwuRepository;


    @Override
    public Fuwu getFuwuById(int id) {
        return fuwuRepository.findOne(id);
    }

    @Override
    public int saveFuwu(Fuwu fuwu) {
        Fuwu fw = fuwuRepository.saveAndFlush(fuwu);
        if (fw != null) {
            return 1;
        }
        return 0;
    }


    @Override
    public int updateFuwuById(Fuwu fuwu) {
        Fuwu fw = fuwuRepository.findOne(fuwu.getId());
        if (fw == null) {
            return 0;
        }
        DaoUtils.copyPropertiesIgnoreNull(fuwu,fw);
        fuwuRepository.saveAndFlush(fw);
        return 1;
    }

    @Override
    public List<Fuwu> findFuwus(Fuwu fuwu) {
        return fuwuRepository.findAll(Example.of(fuwu));
    }

    @Override
    public int deleteFuwuById(int id) {
        fuwuRepository.delete(id);
        return 1;
    }
}
