package com.gzm.mall.nosql.elasticsearch.repository;

import com.gzm.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * description
 *
 * @author gzm
 * @Date 2020/06/15 17:15
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    /**
     * 搜索查询(衍生查询 idea会直接提示字段)
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
