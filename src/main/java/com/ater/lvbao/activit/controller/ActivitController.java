package com.ater.lvbao.activit.controller;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 业务数据测试.
 * 
 * Created by Bryce Yao<sysyaoyulong@gmail.com> on 2017-06-15.
 */
@RestController
@RequestMapping("/activit")
public class ActivitController {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private TaskService taskService;


	@RequestMapping(value = "/deploy/{flowNm}", method = RequestMethod.GET)
	public String test(@PathVariable("flowNm") String flowNm) {

		String msg = "发布成功";
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

			Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
					.createDeployment()// 创建部署对象
					.name(flowNm)// 声明流程的名称
					.addClasspathResource("processes/"+flowNm + ".bpmn")// 加载资源文件，一次只能加载一个文件
					// .addClasspathResource("diagrams/helloworld.png")//
					.deploy();// 完成部署
			System.out.println("部署ID：" + deployment.getId());// 1
			System.out.println("部署时间：" + deployment.getDeploymentTime());

		} catch (Exception e) {
			msg = "发布失败：" + e.toString();

		}

		return msg;
	}


	@RequestMapping(value = "/start/{flowNm}", method = RequestMethod.GET)
	public String startFlow(@PathVariable("flowNm") String flowNm) {
		
        ProcessInstance processInstance = null;
        String processInstanceId = "faild";
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId("zhoujq");
            processInstance = runtimeService.startProcessInstanceByKey(flowNm);
            processInstanceId = processInstance.getId();
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstanceId;
	}
	
	
	@RequestMapping(value = "/getTaskByNm/{userId}", method = RequestMethod.GET)
	public String getBy(@PathVariable("userId") String userId) {

        String msg = "faild";
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        	 List<Task> tasks = taskService.createTaskQuery().taskCandidateUser(userId).list();
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return msg;
	}
	
	

}
