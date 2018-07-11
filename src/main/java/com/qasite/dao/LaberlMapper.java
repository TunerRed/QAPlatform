package com.qasite.dao;

import com.qasite.bean.Laberl;
import com.qasite.bean.LaberlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LaberlMapper {
    long countByExample(LaberlExample example);

    int deleteByExample(LaberlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Laberl record);

    int insertSelective(Laberl record);

    List<Laberl> selectByExample(LaberlExample example);

    Laberl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Laberl record, @Param("example") LaberlExample example);

    int updateByExample(@Param("record") Laberl record, @Param("example") LaberlExample example);

    int updateByPrimaryKeySelective(Laberl record);

    int updateByPrimaryKey(Laberl record);
}