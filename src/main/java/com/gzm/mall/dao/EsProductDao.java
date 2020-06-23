package com.gzm.mall.dao;

import com.gzm.mall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description
 *
 * @author gzm
 * @Date 2020/06/15 17:28
 */
public interface EsProductDao {
    /**
     * 获取商品信息
     * @param id
     * @return
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
