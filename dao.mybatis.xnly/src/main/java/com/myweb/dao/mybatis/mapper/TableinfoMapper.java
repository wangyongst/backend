package com.myweb.dao.mybatis.mapper;

import com.myweb.pojo.Tableinfo;
import com.myweb.pojo.TableinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TableinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    long countByExample(TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int deleteByExample(TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int insert(Tableinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int insertSelective(Tableinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    List<Tableinfo> selectByExample(TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    Tableinfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int updateByExampleSelective(@Param("record") Tableinfo record, @Param("example") TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int updateByExample(@Param("record") Tableinfo record, @Param("example") TableinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int updateByPrimaryKeySelective(Tableinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tableinfo
     *
     * @mbg.generated Fri Dec 23 22:04:23 CST 2016
     */
    int updateByPrimaryKey(Tableinfo record);
}