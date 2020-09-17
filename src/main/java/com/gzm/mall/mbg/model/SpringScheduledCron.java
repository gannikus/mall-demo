package com.gzm.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "spring_scheduled_cron")
public class SpringScheduledCron implements Serializable {

    @ApiModelProperty(value = "主键id")
    @Id
    private Integer cronId;

    @ApiModelProperty(value = "定时任务完整类名")
    private String cronKey;

    @ApiModelProperty(value = "cron表达式")
    private String cronExpression;

    @ApiModelProperty(value = "任务描述")
    private String taskExplain;

    @ApiModelProperty(value = "状态,1:正常;2:停用")
    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getCronId() {
        return cronId;
    }

    public void setCronId(Integer cronId) {
        this.cronId = cronId;
    }

    public String getCronKey() {
        return cronKey;
    }

    public void setCronKey(String cronKey) {
        this.cronKey = cronKey;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTaskExplain() {
        return taskExplain;
    }

    public void setTaskExplain(String taskExplain) {
        this.taskExplain = taskExplain;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cronId=").append(cronId);
        sb.append(", cronKey=").append(cronKey);
        sb.append(", cronExpression=").append(cronExpression);
        sb.append(", taskExplain=").append(taskExplain);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
