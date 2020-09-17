package com.gzm.mall.controller;

import com.gzm.mall.common.CommonResult;
import com.gzm.mall.common.ScheduledOfTask;
import com.gzm.mall.common.utils.CronUtils;
import com.gzm.mall.mbg.repository.SpringScheduledCronRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *  管理定时任务(需要做权限控制)，具体的业务逻辑应
 *  * 该写在Service里，良好的设计是Controller本身
 *  * 只处理很少甚至不处理工作，业务逻辑均委托给
 *  * Service进行处理，这里我偷一下懒，都写在Controller
 *
 * @author 甘之萌  2020/09/16 17:00
 */
@Api(tags = "定时任务"  )
@RestController
@RequestMapping("/scheduled/task")
public class TaskController {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private SpringScheduledCronRepository cronRepository;
    /**
     * 查看任务列表
     */
    @GetMapping("/taskList")
    @ApiOperation("定时任务查询列表")
    public String taskList(Model model) {
        model.addAttribute("cronList", cronRepository.findAll());
        return "task-list";
    }
    /**
     * 编辑任务cron表达式
     */
    @ApiOperation("编辑任务cron表达式")
    @PostMapping("/editTaskCron")
    public CommonResult<Void> editTaskCron(String cronKey, String newCron) {
        if (!CronUtils.isValidExpression(newCron)) {
            throw new IllegalArgumentException("失败,非法表达式:" + newCron);
        }
        cronRepository.updateCronExpressionByCronKey(newCron, cronKey);
        return  CommonResult.success(null);
    }
    /**
     * 执行定时任务
     */
    @ApiOperation("执行定时任务")
    @PostMapping("/runTaskCron")
    public CommonResult<Void> runTaskCron(String cronKey) throws Exception {
        ((ScheduledOfTask) context.getBean(Class.forName(cronKey))).execute();
        return  CommonResult.success(null,"执行成功");
    }
    /**
     * 启用或禁用定时任务
     */
    @ApiOperation("启用或禁用定时任务")
    @PostMapping("/changeStatusTaskCron")
    public CommonResult<Void> changeStatusTaskCron(Integer status, String cronKey) {
        cronRepository.updateStatusByCronKey(status, cronKey);
        return CommonResult.success(null,"操作成功");

    }
}
