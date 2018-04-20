package com.ater.lvbao.common.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * 工具类
 *
 * @author Onpu
 * @create 2018-01-02 23:18
 **/
public class MyUtils {
    /**
     * 查询日期范围分割
     *
     * @param params
     * @param paramName
     */
    public static void splitDateRange(Map<String, Object> params, String paramName) {
        String dateTimeRange = (String) params.get(paramName);
        if (!StringUtils.isEmpty(dateTimeRange)) {
            String[] dateTimeRangeArr = dateTimeRange.split(",");
            params.put(paramName + "Start", dateTimeRangeArr[0]);
            params.put(paramName + "End", dateTimeRangeArr[1]);
        }
    }
}
