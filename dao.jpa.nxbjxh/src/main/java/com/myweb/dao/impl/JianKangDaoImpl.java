package com.myweb.dao.impl;

import com.myweb.dao.JianKangDao;
import com.myweb.dao.jpa.hibernate.CaijiRepository;
import com.myweb.pojo.Caiji;
import com.myweb.util.DaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository("jianKangDao")
public class JianKangDaoImpl implements JianKangDao {

    @Autowired
    private CaijiRepository caijiRepository;


    @Override
    public Caiji getCaijiById(int id) {
        return caijiRepository.findOne(id);
    }

    @Override
    public int saveCaiji(Caiji caiji) {
        Caiji cj = caijiRepository.saveAndFlush(caiji);
        if (cj != null) {
            return 1;
        }
        return 0;
    }

    public int updateCaijiById(Caiji caiji) {
        Caiji cj = caijiRepository.findOne(caiji.getId());
        if (cj == null) {
            return 0;
        }
        DaoUtils.copyPropertiesIgnoreNull(caiji,cj);
        caijiRepository.saveAndFlush(cj);
        return 1;
    }

    @Override
    public List<Caiji> findCaijis(Caiji caiji) {
        return caijiRepository.findAll(Example.of(caiji));
    }

    @Override
    public int deleteCaijiById(int id) {
        caijiRepository.delete(id);
        return 1;
    }
}
