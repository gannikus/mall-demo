package com.gzm.mall.mbg.mapper;

import com.gzm.mall.mbg.BaseMapper;
import com.gzm.mall.mbg.model.CmsHelpCategory;
import com.gzm.mall.mbg.model.CmsHelpCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsHelpCategoryMapper extends BaseMapper<CmsHelpCategory> {
    long countByExample(CmsHelpCategoryExample example);

    int deleteByExample(CmsHelpCategoryExample example);

    int deleteByPrimaryKey(Long id);
    @Override
    int insert(CmsHelpCategory record);
    @Override
    int insertSelective(CmsHelpCategory record);

    List<CmsHelpCategory> selectByExample(CmsHelpCategoryExample example);

    CmsHelpCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsHelpCategory record, @Param("example") CmsHelpCategoryExample example);

    int updateByExample(@Param("record") CmsHelpCategory record, @Param("example") CmsHelpCategoryExample example);
    @Override
    int updateByPrimaryKeySelective(CmsHelpCategory record);
    @Override
    int updateByPrimaryKey(CmsHelpCategory record);
}
