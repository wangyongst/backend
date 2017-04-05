package com.myweb.dao.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.dao.jpa.hibernate.*;
import com.myweb.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("frameWorkDao")
public class FrameWorkDaoImpl implements FrameWorkDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TableinfoRepository tableinfoRepository;

    @Autowired
    private ShuxingRepository shuxingRepository;

    @Autowired
    private LaorenRepository laorenRepository;

    @Autowired
    private CaijiRepository caijiRepository;

    @Autowired
    private FuwuRepository fuwuRepository;

    @Override
    public List<User> findUsersByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Menu> findMenusByParentAndRole(int parent, String role) {
        return menuRepository.queryByParentAndRole(parent, role);
    }

    @Override
    public long totalLaoren() {
        return laorenRepository.count();
    }

    @Override
    public long totalCaiji() {
        return caijiRepository.count();
    }

    @Override
    public long totalFuwu(String fuwutype) {
        Fuwu fuwu = new Fuwu();
        fuwu.setFuwutype(fuwutype);
        return fuwuRepository.count(Example.of(fuwu));

    }

    @Override
    public List<Tableinfo> findTableinfosByDisable(String tablename, Integer tabledisable, Integer modaldisable) {
        Tableinfo tableinfo = new Tableinfo();
        tableinfo.setTablename(tablename);
        tableinfo.setTabledisable(tabledisable);
        tableinfo.setModaldisable(modaldisable);
        return tableinfoRepository.findAll(Example.of(tableinfo), new Sort(Sort.Direction.ASC, "shunxu"));
    }

    @Override
    public List<Shuxing> findShuxingsByName(String name) {
        Shuxing shuxing = new Shuxing();
        shuxing.setName(name);
        return shuxingRepository.findAll(Example.of(shuxing), new Sort(Sort.Direction.ASC, "shunxu"));
    }

}
