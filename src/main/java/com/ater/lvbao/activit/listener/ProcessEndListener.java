package com.ater.lvbao.activit.listener;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程结束监听器
 *
 * @author: zhoujq
 */
@Service
@Transactional
public class ProcessEndListener implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    ActivitiDao activitiDao;

    @Override
    public void notify(DelegateExecution execution) {
//        String processInstanceId = execution.getProcessInstanceId();
//
//        int i = activitiDao.deleteFormPropertyByProcessInstanceId(processInstanceId);
       
    }
}
