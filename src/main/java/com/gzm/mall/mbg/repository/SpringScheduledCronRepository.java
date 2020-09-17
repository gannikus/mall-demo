package com.gzm.mall.mbg.repository;

import com.gzm.mall.mbg.model.SpringScheduledCron;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author 甘之萌  2020/09/16 14:42
 */
@CacheConfig(cacheNames = "b2c:scheduled:cache")
public interface SpringScheduledCronRepository extends JpaRepository<SpringScheduledCron, Integer> {
    @Cacheable
    SpringScheduledCron findByCronKey(String cronKey);

    /**
     * 更新定时任务cron表达式
     *
     * @param newCron
     * @param cronKey
     * @return
     */
    @CacheEvict(key = "#root.args[1]", beforeInvocation = true)
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update spring_scheduled_cron set cron_expression=?1 where cron_key=?2", nativeQuery = true)
    int updateCronExpressionByCronKey(String newCron, String cronKey);

    /**
     * 更新定时任务状态
     *
     * @param status
     * @param cronKey
     * @return
     */
    @CacheEvict(key = "#root.args[1]", beforeInvocation = true)
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query(value = "update spring_scheduled_cron set status=?1 where cron_key=?2", nativeQuery = true)
    int updateStatusByCronKey(Integer status, String cronKey);
}
