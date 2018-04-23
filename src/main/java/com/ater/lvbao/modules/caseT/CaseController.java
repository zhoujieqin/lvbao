package com.ater.lvbao.modules.caseT;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ater.lvbao.activit.ActivitBean;
import com.ater.lvbao.activit.ActivitService;

/**
 * 业务数据测试.
 * 
 * Created by zhoujq 2018-4-20
 */
@RestController
@RequestMapping("/case")
public class CaseController {

	@Autowired
	private CaseService caseService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String startFlow(@RequestBody CaseEntity entity) {
		try {
			caseService.insert(entity);
		}catch(Exception e) {	
			return "false";
		}
        return "true";
	}
	
	
	@RequestMapping(value = "/getWaitList", method = RequestMethod.GET)
	public List<CaseEntity> getWaitList(@RequestParam String userId) {
		List<CaseEntity> result = null;
		try {
			 result = caseService.getWaitList(userId);
		}catch(Exception e) {	
			return result;
		}
        return result;
	}
	
	
	
	

}
