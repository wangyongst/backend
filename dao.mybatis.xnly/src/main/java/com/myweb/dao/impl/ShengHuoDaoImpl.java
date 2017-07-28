package com.myweb.dao.impl;

import com.myweb.dao.ShengHuoDao;
import com.myweb.dao.mybatis.mapper.FuwuMapper;
import com.myweb.pojo.Fuwu;
import com.myweb.pojo.FuwuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("shengHuoDao")
public class ShengHuoDaoImpl implements ShengHuoDao {

    @Autowired
    private FuwuMapper fuwuMapper;


    @Override
    public Fuwu getFuwuById(int id) {
        return fuwuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveFuwu(Fuwu fuwu) {
        return fuwuMapper.insert(fuwu);
    }


    @Override
    public int updateFuwuById(Fuwu fuwu) {
        return fuwuMapper.updateByPrimaryKeySelective(fuwu);

    }

    @Override
    public List<Fuwu> findFuwus(Fuwu fuwu) {
        FuwuExample fuwuExample = new FuwuExample();
        FuwuExample.Criteria criteria = fuwuExample.createCriteria();
        if(fuwu.getFuwutype() != null){
            criteria.andFuwutypeEqualTo(fuwu.getFuwutype());
        }

        return fuwuMapper.selectByExample(fuwuExample);
    }

    @Override
    public int deleteFuwuById(int id) {
        return fuwuMapper.deleteByPrimaryKey(id);
    }
}
