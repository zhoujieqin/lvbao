package com.ater.lvbao.modules.service;

import com.ater.lvbao.modules.entity.SysLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统日志接口
 */
public interface SysLogService {

    /**
     * 查询日志信息
     *
     * @param id
     * @return
     */
    SysLogEntity queryObject(Long id);

    /**
     * 查询日志列表
     *
     * @param map
     * @return
     */
    List<SysLogEntity> queryList(Map<String, Object> map);

    /**
     * 查询日志总数
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存日志信息
     *
     * @param sysLog
     */
    void save(SysLogEntity sysLog);

}
