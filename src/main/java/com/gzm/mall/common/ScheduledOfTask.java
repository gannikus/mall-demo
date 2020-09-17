package com.gzm.mall.common;

/**
 * description
 *
 * @author 甘之萌  2020/09/16 14:48
 */

import com.gzm.mall.common.utils.SpringContextUtil;
import com.gzm.mall.mbg.model.SpringScheduledCron;
import com.gzm.mall.mbg.repository.SpringScheduledCronRepository;


public interface ScheduledOfTask extends Runnable {
    /**
     * 定时任务方法
     */
    void execute();
    /**
     * 实现控制定时任务启用或禁用的功能
     */
    @Override
    default void run() {
        SpringScheduledCronRepository repository = SpringContextUtil.get(SpringScheduledCronRepository.class);
        SpringScheduledCron scheduledCron = repository.findByCronKey(this.getClass().getName());
        if (StatusEnum.DISABLED.getCode()==(scheduledCron.getStatus())) {
            // 任务是禁用状态
            return;
        }
        execute();
    }
}
