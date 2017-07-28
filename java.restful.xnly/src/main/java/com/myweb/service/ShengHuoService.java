package com.myweb.service;

import com.myweb.pojo.Fuwu;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShengHuoService {

    Result getFuwu(HttpSession session, String id);

    Result createFuwu(HttpSession session, Fuwu fuwu);

    Result updateFuwu(HttpSession session, Fuwu fuwu);

    List<Fuwu> listFuwus(HttpSession session, Fuwu fuwu);

    Result deleteFuwu(HttpSession session, String ids);
}