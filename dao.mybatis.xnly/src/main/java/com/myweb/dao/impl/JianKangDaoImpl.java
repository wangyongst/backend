package com.myweb.dao.impl;

import com.myweb.dao.JianKangDao;
import com.myweb.dao.mybatis.mapper.CaijiMapper;
import com.myweb.pojo.Caiji;
import com.myweb.pojo.CaijiExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jianKangDao")
public class JianKangDaoImpl implements JianKangDao {

    @Autowired
    private CaijiMapper caijiMapper;


    @Override
    public Caiji getCaijiById(int id) {
        return caijiMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveCaiji(Caiji caiji) {
        return caijiMapper.insert(caiji);

    }

    public int updateCaijiById(Caiji caiji) {
        return caijiMapper.updateByPrimaryKeySelective(caiji);
    }

    @Override
    public List<Caiji> findCaijis(Caiji caiji) {
        CaijiExample caijiExample = new CaijiExample();
        CaijiExample.Criteria criteria = caijiExample.createCriteria();
        if(caiji.getLaorenid() != null){
            criteria.andLaorenidEqualTo(caiji.getLaorenid());
        }
        return caijiMapper.selectByExample(caijiExample);
    }

    @Override
    public int deleteCaijiById(int id) {
        return caijiMapper.deleteByPrimaryKey(id);
    }
}
