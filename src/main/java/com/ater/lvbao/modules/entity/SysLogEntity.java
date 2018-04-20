package com.ater.lvbao.modules.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 *
 * @author Onpu
 * @date 2017-04-01
 */
public class SysLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;
    /**
     * 操作人
     */
    private String userName;
    /**
     * 操作时间
     */
    private Date operationTime;
    /**
     * 操作内容
     */
    private String operationContent;
    /**
     * 执行时长(毫秒)
     */
    private Long executePhase;
    /**
     * IP地址
     */
    private String userIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public Long getExecutePhase() {
        return executePhase;
    }

    public void setExecutePhase(Long executePhase) {
        this.executePhase = executePhase;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
