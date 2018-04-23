package com.ater.lvbao.activit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActivitService {

	 @Autowired
    private RuntimeService runtimeService;
	 @Autowired
    protected TaskService taskService;
	 @Autowired
    protected HistoryService historyService;
	@Autowired
    protected RepositoryService repositoryService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private FormService formService;

    /**
     * 启动流程
     *
     * @param entity
     */
    public ProcessInstance startWorkflow( ActivitBean entity, Map<String, Object> variables) {
        
        String businessKey = entity.getBusinessKey();

        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getUserId());


            processInstance = runtimeService.startProcessInstanceByKey(entity.getProcessKey(), businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity.setProcessInstanceId(processInstanceId);
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }
    
    /**
     * 启动流程
     *
     * @param entity
     */
    public String getstarForm(String processKey) { 
         ProcessDefinition pd = repositoryService.createProcessDefinitionQuery() //createProcessDefinitionQuery().processDefinitionKey(processKey).singleResult();
                 .deploymentId("2501").singleResult();  
         return  formService.getStartFormKey(pd.getId());
    }

    /**
     * 查询某个流程类型某人的待办任务
     *
     * @param userId 用户ID
     * @return
     */
    @Transactional(readOnly = true)
    public List<ActivitBean> findTodoTasks(String userId,String processKey) {
        List<ActivitBean> results = new ArrayList<ActivitBean>();

        // 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId).processDefinitionKey(processKey);
        List<Task> tasks = taskQuery.list();

        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            if (processInstance == null) {
                continue;
            }
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
           
            ActivitBean bean = new ActivitBean();
            bean.setBusinessKey(businessKey);
            bean.setTaskId(task.getId());
            bean.setTaskName(task.getName());
            bean.setFormKey(task.getFormKey());
            results.add(bean);
        }

       
        return results;
    }

    /**
     * 读取某个流程运行中的实例
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<ActivitBean> findRunningProcessInstaces(ActivitBean bean) {
        List<ActivitBean> results = new ArrayList<ActivitBean>();
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey(bean.getProcessKey()).active().orderByProcessInstanceId().desc();
       
        List<ProcessInstance> list = query.list();

        // 关联业务实体
        for (ProcessInstance processInstance : list) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            ActivitBean acbean = new ActivitBean();
            acbean.setBusinessKey(businessKey);
           //acbean.setProcessInstance(processInstance);
            results.add(acbean);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().list();
            //acbean.setTask(tasks.get(0));
            results.add(acbean);
        }
        return results;
    }

    /**
     * 读取已结束中的流程
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<ActivitBean> findFinishedProcessInstaces(ActivitBean bean, int[] pageParams) {
        List<ActivitBean> results = new ArrayList<ActivitBean>();
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey(bean.getProcessKey()).finished().orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);
        // 关联业务实体
        for (HistoricProcessInstance historicProcessInstance : list) {
            String businessKey = historicProcessInstance.getBusinessKey();
        }
        return results;
    }

    /**
     * 查询流程定义对象
     *
     * @param processDefinitionId 流程定义ID
     * @return
     */
    protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        return processDefinition;
    }

}
