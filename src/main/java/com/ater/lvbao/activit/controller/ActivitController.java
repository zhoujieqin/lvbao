package com.ater.lvbao.activit.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                .createDeployment()//创建部署对象
                .name("helloworld演示")//声明流程的名称
                .addClasspathResource("processes/vacationRequest.bpmn")//加载资源文件，一次只能加载一个文件
               // .addClasspathResource("diagrams/helloworld.png")//
                .deploy();//完成部署


        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署时间："+deployment.getDeploymentTime());


        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest");
        return "ok";
    }

}
