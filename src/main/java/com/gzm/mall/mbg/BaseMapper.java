package com.gzm.mall.mbg;

import tk.mybatis.mapper.common.*;

/**
 * 通用mapper
 *
 * @author gzm
 * @Date 2020/08/25 15:11
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> ,  ConditionMapper<T>, IdsMapper<T>,Marker{
}
