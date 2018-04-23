package com.ater.lvbao.modules.caseT;

import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ater.lvbao.activit.ActivitBean;
import com.ater.lvbao.activit.ActivitService;

@Service
public class CaseService {

	@Autowired
	private ActivitService activitService;
	@Autowired
	private CaseDao caseDao;
	
	private final String flowNm = "law";
	
	
	public void insert(CaseEntity entity) {
		
		ActivitBean ac= new ActivitBean();
    	ac.setUserId(entity.getUserId());
    	ac.setProcessKey(flowNm);
    	ac.setBusinessKey(entity.getCaseNo());
		Map<String, Object> formProperties = new HashMap<String, Object>();  
		formProperties.put("caseNo", entity.getCaseNo());
		formProperties.put("caseName", entity.getCaseName());
		ProcessInstance pn = activitService.startWorkflow(ac, formProperties);
		entity.setProcessInstanceId(pn.getId());
		this.insertEntity(entity);
	}
	
	
	public void insertEntity(CaseEntity entity) {
		caseDao.save(entity);
	}
	
	public List<CaseEntity> getWaitList(String userID) {
		List<CaseEntity> result = new ArrayList<CaseEntity>();
		try {
			List<ActivitBean> tasks = activitService.findTodoTasks(userID, flowNm);
			String caseNo= "";
			for(ActivitBean ac : tasks){
				CaseEntity tmp =  caseDao.queryObject(ac.getBusinessKey());
				tmp.setTaskId(ac.getTaskId());
				tmp.setTaskName(ac.getTaskName());
				tmp.setTaskForm(ac.getFormKey());
				result.add(tmp);
			}
			
		}catch(Exception e) {	
			return result;
		}
        return result;
	}


}
