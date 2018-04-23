package com.ater.lvbao.activit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 业务数据测试.
 * 
 * Created by zhoujq 2018-4-20
 */
@RestController
@RequestMapping("/activit")
public class ActivitController {

	@Autowired
	private ActivitService activitService;
	
	@Autowired
	protected TaskService taskService;
	
	@Autowired
	protected FormService formService;

	@RequestMapping(value = "/deploy/{flowNm}", method = RequestMethod.GET)
	public String test(@PathVariable("flowNm") String flowNm) {

		String msg = "发布成功";
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

			Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
					.createDeployment()// 创建部署对象
					.name(flowNm)// 声明流程的名称
					.addClasspathResource("processes/" + flowNm + ".bpmn")// 加载资源文件，一次只能加载一个文件
					// .addClasspathResource("diagrams/helloworld.png")//
					.deploy();// 完成部署
			System.out.println("部署ID：" + deployment.getId());// 1
			System.out.println("部署时间：" + deployment.getDeploymentTime());

		} catch (Exception e) {
			msg = "发布失败：" + e.toString();

		}

		return msg;
	}
	
	@RequestMapping(value = "/deploy/leave", method = RequestMethod.GET)
	public String test1() {

		String msg = "发布成功";
		try {
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

			Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
					.createDeployment()// 创建部署对象
					.name("请假")// 声明流程的名称
					.addClasspathResource("processes/leave2.bpmn")// 加载资源文件，一次只能加载一个文件
				    .addClasspathResource("processes/dept-leader-audit.form")//
				    .addClasspathResource("processes/hr-audit.form")//
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
    	ActivitBean ac= new ActivitBean();
    	ac.setUserId("wangwu");
    	ac.setProcessKey(flowNm);
    	ac.setBusinessKey("12");
		Map<String, Object> formProperties = new HashMap<String, Object>();  
		formProperties.put("caseNo", "11111。。。");
		formProperties.put("caseName", "案件美美美");
    	 
    	activitService.startWorkflow(ac, formProperties);   
        return ac.getProcessInstanceId();
	}
	
	/**
	 * 获得初始form表单
	 * @param flowNm
	 * @return
	 */
	@RequestMapping(value = "/new/{flowNm}", method = RequestMethod.GET)
	public String newFlow(@PathVariable("flowNm") String flowNm) {
        return activitService.getstarForm(flowNm);
	}

	@RequestMapping(value = "/getTaskByNm", method = RequestMethod.GET)
	public List<ActivitBean> getBy(@RequestParam  String userId,@RequestParam  String processKey) {
		List<ActivitBean> result = activitService.findTodoTasks(userId,processKey);   
		return result;
	}
	
	/** 
     * 读取Task的表单 
     * @RequestMapping(value = "get-form/task/{processDefinitionkey}") 
     * @PathVariable("processDefinitionkey") String processDefinitionkey 
     */  
    @RequestMapping(value = "/getTaskform")  
    @ResponseBody  
    public String getTaskForm(  
    		@RequestParam String taskId) throws Exception {
        TaskFormData formData = formService.getTaskFormData(taskId);  
        String formKey = formData.getFormKey();
  
        return formKey;  
    }
    
  
	
	/** 
     * 读取Task的表单 
     * @RequestMapping(value = "get-form/task/{processDefinitionkey}") 
     * @PathVariable("processDefinitionkey") String processDefinitionkey 
     */  
    @RequestMapping(value = "/getform/task/{processInstanceId}")  
    @ResponseBody  
    public String findTaskForm(  
            @PathVariable("processInstanceId") String processInstanceId) throws Exception {  
        ModelAndView mav = new ModelAndView("leave/apply");  
        // 获取当前登陆人信息。  
        /* User user = UserUtil.getUserFromSession(request.getSession()); */  
          
        TaskQuery taskQuery = taskService.createTaskQuery()  
                .processInstanceId(processInstanceId).orderByProcessInstanceId().desc();  
                  
        List<Task> tasks = taskQuery.list();  
        if (tasks.size()==0) {   
            return "流程结束";  
        }  
        Task task = tasks.get(0);  
       
        
        Map<String, String> formProperties = new HashMap<String, String>();  
        formProperties.put("caseNo", "11111");
        Object renderedTaskForm = formService.getRenderedTaskForm(task.getId());

        TaskFormData formData = formService.getTaskFormData(task.getId());  
        String formKey = formData.getFormKey();
        
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        List<FormProperty> list = processEngine.getFormService().getTaskFormData(task.getId()).getFormProperties();  
//        
//        if(list!=null && list.size()>0){  
//            for(FormProperty formProperty:list){  
//                System.out.println(formProperty.getId() + "     " + formProperty.getName() + "      " +formProperty.getValue());  
//            }  
//        }  
//        
//        System.out.println(renderedTaskForm.toString());  
//        mav.addObject("renderedTaskForm", renderedTaskForm.toString());//整个页面，参数已经赋值（整个页面是什么时候赋上值的？）  
//        mav.addObject("taskId", task.getId());  
//        mav.addObject("processInstanceId", processInstanceId);  
        return formKey;  
    }  
  
    /** 
     * 办理任务，提交task的并保存form 
     */  
    @RequestMapping(value = "task/complete/{taskId}")  
    @SuppressWarnings("unchecked")  
    public String completeTask(@PathVariable("taskId") String taskId, @RequestParam Map<String, Object> parameterMap) {  
          
       
 
        try {
//        	//外置form
//        	 Map<String, String> formProperties = new HashMap<String, String>();  
//             formProperties.put("deptLeaderPass", "true");
//            formService.submitTaskFormData(taskId, formProperties);  
            //其他情况
            //Map<String, Object> formProperties1 = new HashMap<String, Object>();  
            //formProperties1.put("deptLeaderPass", "true");
            taskService.complete(taskId, parameterMap);
        } finally {  
            //identityService.setAuthenticatedUserId(null);  
        }  
 
        return "任务完成"+taskId;  
         
    }  

}
