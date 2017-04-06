package com.myweb.service.impl;

import com.myweb.service.XueXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("xiTongService")
@Transactional(value = "myTM", readOnly = true)
public class XueXiServiceImpl implements XueXiService {

}
