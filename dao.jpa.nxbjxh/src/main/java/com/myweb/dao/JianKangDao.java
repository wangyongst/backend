package com.myweb.dao;

import com.myweb.pojo.Caiji;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface JianKangDao {

    public Caiji getCaijiById(int id);

    public int saveCaiji(Caiji caiji);

    public int updateCaijiById(Caiji caiji);

    public List<Caiji> findCaijis(Caiji caiji);

    public int deleteCaijiById(int id);
}