package com.gzm.mall.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author 甘之萌  2020/09/17 17:04
 */
@Component
public class DynamicPrintTask implements ScheduledOfTask{
    private Logger logger = LoggerFactory.getLogger(getClass());

    private int i;

    @Override
    public void execute() {
        logger.info("thread id:{},DynamicPrintTask execute times:{}", Thread.currentThread().getId(), ++i);
    }
}
