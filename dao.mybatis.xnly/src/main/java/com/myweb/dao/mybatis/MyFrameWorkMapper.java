package com.myweb.dao.mybatis;

import com.myweb.pojo.Caiji;
import com.myweb.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangy on 2016-12-20.
 */
public interface MyFrameWorkMapper {

    List<Menu> queryByParentAndRole(@Param("parent") int parent, @Param("role") String role);
}
