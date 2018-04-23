package com.ater.lvbao.modules.caseT;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author Onpu
 * @date 2017-04-01
 */
public class CaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String taskId;
    
    private String taskName;
    
    private String caseName;
    
    private String  userId;
    
    private String taskForm;
    
    public String getTaskForm() {
		return taskForm;
	}
	public void setTaskForm(String taskForm) {
		this.taskForm = taskForm;
	}
	private String processInstanceId;

    public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	private String caseNo;
    /**
     *用户名
     */

	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
    

    
}
