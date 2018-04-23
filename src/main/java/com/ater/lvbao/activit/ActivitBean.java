package com.ater.lvbao.activit;

public class ActivitBean {

	// 业务实体key
	private String businessKey;

	private String userId;
	
	private String formKey;

	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

	// 流程key
	private String processKey;
	// 流程实体ID
	private String processInstanceId;
	
	//private ProcessInstance processInstance;
	
//	public ProcessInstance getRocessInstance() {
//		return processInstance;
//	}
//
//	public void setProcessInstance(ProcessInstance processInstance) {
//		this.processInstance = processInstance;
//	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	private String taskId;
	
	private  String taskName;


	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

}
