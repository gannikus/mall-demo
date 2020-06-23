package com.gzm.mall.nosql.mongodb.repository;

import com.gzm.mall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商品浏览历史Repository
 *
 * @author gzm
 * @Date 2020/06/17 15:07
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录(衍生查询)
     * @param memberId 会员id
     * @return MemberReadHistory
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
